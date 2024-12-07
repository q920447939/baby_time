package com.musk.web.controller.uploadlist;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussRespVO;
import com.musk.web.controller.uploadimage.vo.UploadImageRespVO;
import com.musk.web.controller.uploadlist.vo.MemberSimpleResVO;
import com.musk.web.controller.uploadlist.vo.UploadListPageReqVO;
import com.musk.web.controller.uploadlist.vo.UploadListRespVO;
import com.musk.web.controller.uploadlist.vo.UploadListSaveReqVO;
import com.musk.web.dal.dataobject.uploaddiscuss.UploadDiscussDO;
import com.musk.web.dal.dataobject.uploadimage.UploadImageDO;
import com.musk.web.dal.dataobject.uploadlist.UploadListDO;
import com.musk.web.service.uploaddiscuss.UploadDiscussService;
import com.musk.web.service.uploadimage.UploadImageService;
import com.musk.web.service.uploadlist.UploadListService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.example.musk.auth.entity.member.MemberDO;
import org.example.musk.auth.service.core.member.MemberService;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.example.musk.common.pojo.CommonResult.success;


@RestController
@RequestMapping("/api/baby/upload-list")
@Validated
public class UploadListController {

    @Resource
    private UploadListService uploadListService;


    @Resource
    private MemberService memberService;


    @Resource
    private UploadDiscussService uploadDiscussService;



    private static final Map<Short,Class<? extends  UploadTypeLoadStrategy>> UPLOAD_TYPE_LOAD_STRATEGY_MAP  = new HashMap<>();
    static {
        UPLOAD_TYPE_LOAD_STRATEGY_MAP.put((short) 1, ImageUploadTypeLoadStrategyImpl.class);
    }

    /**
     * 创建上传记录
     */
    @PostMapping("/create")
    public CommonResult<Integer> createUploadList(@Valid @RequestBody UploadListSaveReqVO createReqVO) {
        return success(uploadListService.createUploadList(createReqVO));
    }

    /**
     * 更新上传记录
     */
    @PutMapping("/update")
    public CommonResult<Boolean> updateUploadList(@Valid @RequestBody UploadListSaveReqVO updateReqVO) {
        uploadListService.updateUploadList(updateReqVO);
        return success(true);
    }

    /**
     * 删除上传记录
     */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteUploadList(@RequestParam("id") Integer id) {
        uploadListService.deleteUploadList(id);
        return success(true);
    }

    /**
     * 获得上传记录
     */
    @GetMapping("/get")
    public CommonResult<UploadListRespVO> getUploadList(@RequestParam("id") Integer id) {
        UploadListDO uploadList = uploadListService.getUploadList(id);
        return success(BeanUtils.toBean(uploadList, UploadListRespVO.class));
    }


    /**
     * 获得上传记录分页
     */
    @GetMapping("/page")
    public CommonResult<PageResult<UploadListRespVO>> getUploadListPage(@Valid UploadListPageReqVO pageReqVO) {
        PageResult<UploadListDO> pageResult = uploadListService.getUploadListPage(pageReqVO);
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> {
            List<UploadListDO> list = pageResult.getList();
            Map<Short,List<UploadListDO>> upLoadTypeMap = new HashMap<>();
            List<Integer> uploadMemberIds = new ArrayList<>(list.size());
            List<Integer> uploadIds = new ArrayList<>(list.size());
            for (UploadListDO uploadListDO : list) {
                List<UploadListDO> uploadLists = upLoadTypeMap.get(uploadListDO.getUploadType());
                if (uploadLists == null) {
                    List<UploadListDO> tmpList = new ArrayList<>();
                    tmpList.add(uploadListDO);
                    upLoadTypeMap.put(uploadListDO.getUploadType(), tmpList);
                } else {
                    uploadLists.add(uploadListDO);
                    upLoadTypeMap.put(uploadListDO.getUploadType(), uploadLists);
                }
                uploadMemberIds.add(uploadListDO.getUploadUser());
                uploadIds.add(uploadListDO.getId());
            }

            List<UploadDiscussDO> uploadDiscussList = uploadDiscussService.queryDiscussByUploadIds(uploadIds);
            if (CollUtil.isNotEmpty(uploadDiscussList)) {
                uploadMemberIds.addAll(uploadDiscussList.stream().map(k->k.getDiscussMemberId()).toList());
            }

            List<MemberDO> memberInfoList = memberService.getMemberInfoByMemberIds(uploadMemberIds);
            Map<Integer, MemberDO> memberDOMap = memberInfoList.stream().collect(Collectors.toMap(k -> k.getId(), Function.identity(), (k1, k2) -> k1));



            Map<Integer, List<UploadDiscussDO>> discussMap = MapUtil.empty();
            if (CollUtil.isNotEmpty(uploadDiscussList)) {
                discussMap = uploadDiscussList.stream().collect(Collectors.groupingBy(k -> k.getUploadId()));
            }

            Map<Short,Object> uploadTypeMaps = new HashMap<>();

            for (Short uploadType : upLoadTypeMap.keySet()) {
                UploadTypeLoadStrategy typeLoadStrategy = SpringUtil.getBean("uploadTypeLoadStrategy" + uploadType,UploadTypeLoadStrategy.class);
                List<UploadListDO> uploadListDOS = upLoadTypeMap.get(uploadType);
                Object loaded = typeLoadStrategy.load(uploadListDOS.stream().map(k -> k.getId()).toList());
                uploadTypeMaps.put(uploadType,loaded);
            }

            List<UploadListRespVO> uploadListRespVOS = BeanUtils.toBean(list, UploadListRespVO.class);
            for (UploadListRespVO uploadListRespVO : uploadListRespVOS) {
                Integer id = uploadListRespVO.getId();
                uploadListRespVO.setMemberSimpleResVO(BeanUtils.toBean(memberDOMap.get(uploadListRespVO.getUploadUser()), MemberSimpleResVO.class));
                List<UploadDiscussDO> uploadDiscussDOList = discussMap.get(id);
                if (uploadDiscussDOList != null) {
                    List<UploadDiscussRespVO> uploadDiscussRespVOList = BeanUtils.toBean(uploadDiscussDOList, UploadDiscussRespVO.class).stream().sorted(Comparator.comparing(UploadDiscussRespVO::getCreateTime).reversed()).toList();
                    uploadDiscussRespVOList.forEach(k->{
                        k.setMemberSimpleResVO(BeanUtils.toBean(memberDOMap.get(k.getDiscussMemberId()),MemberSimpleResVO.class));
                    });
                    uploadListRespVO.setUploadDiscussRespVO(uploadDiscussRespVOList);
                }
                UploadTypeLoadStrategy typeLoadStrategy = SpringUtil.getBean("uploadTypeLoadStrategy" + uploadListRespVO.getUploadType(),UploadTypeLoadStrategy.class);
                typeLoadStrategy.set(uploadListRespVO,uploadTypeMaps);
            }
            return new PageResult<>(uploadListRespVOS, pageResult.getTotal());
        });
    }

    public interface UploadTypeLoadStrategy{
         Object load(List<Integer> uploadIds);
         void set(UploadListRespVO uploadListRespVO, Object upLoadTypeInfoMap);
    }



    @Component("uploadTypeLoadStrategy" + "1")
    public  class ImageUploadTypeLoadStrategyImpl implements UploadTypeLoadStrategy{
        @Override
        public Object load(List<Integer> uploadIds) {
            List<UploadImageDO> uploadImageDOList = SpringUtil.getBean(UploadImageService.class).queryUploadImageByUploadIds(uploadIds);
            if (CollUtil.isEmpty(uploadImageDOList)) {
                return MapUtil.empty();
            }
            return  uploadImageDOList.stream().collect(Collectors.groupingBy(k -> k.getUploadId()));
        }

        @Override
        public void set(UploadListRespVO uploadListRespVO, Object upLoadTypeInfoMap) {
            Map<Short, Map<Integer,List<UploadImageDO>>> upLoadTypeMap = (Map<Short, Map<Integer,List<UploadImageDO>>> ) upLoadTypeInfoMap;
            Map<Integer, List<UploadImageDO>> shortListMap = upLoadTypeMap.get(uploadListRespVO.getUploadType().shortValue());
            if (CollUtil.isEmpty(shortListMap)) {
                return;
            }
            List<UploadImageDO> uploadImageDOList = shortListMap.get(uploadListRespVO.getId());
            if (CollUtil.isNotEmpty(uploadImageDOList)) {
                uploadListRespVO.setUploadImageRespVO(BeanUtils.toBean(uploadImageDOList, UploadImageRespVO.class).stream().sorted(Comparator.comparing(UploadImageRespVO::getCreateTime).reversed()).toList());
            }
        }
    }
}
