package com.musk.web.controller.babyUploadListRelationTag;

import com.musk.web.controller.babyUploadListRelationTag.vo.BabyUploadListRelationTagAddReqVO;
import com.musk.web.controller.babyUploadListRelationTag.vo.BabyUploadListRelationTagPageReqVO;
import com.musk.web.controller.babyUploadListRelationTag.vo.BabyUploadListRelationTagRespVO;
import com.musk.web.controller.babyUploadListRelationTag.vo.BabyUploadListRelationTagUpdateReqVO;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.BabyUploadListRelationTagDO;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.bo.BabyUploadListRelationTagPageReqBO;
import com.musk.web.service.babyUploadListRelationTag.BabyUploadListRelationTagService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static org.example.musk.common.pojo.CommonResult.success;

/**
 * 宝宝上传记录与标签关联 Controller
 *
 * @author 代码生成器
 */
@RestController
@RequestMapping("/api/babyUploadListRelationTag")
@Validated
@Slf4j
public class BabyUploadListRelationTagController {

    @Resource
    private BabyUploadListRelationTagService babyUploadListRelationTagService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody BabyUploadListRelationTagAddReqVO createReqVO) {
        return success(babyUploadListRelationTagService.createBabyUploadListRelationTag(BeanUtils.toBean(createReqVO, BabyUploadListRelationTagDO.class)));
    }
    @PutMapping("/updateById")
    public CommonResult<Boolean> update(@Valid @RequestBody BabyUploadListRelationTagUpdateReqVO updateReqVO) {
        babyUploadListRelationTagService.updateBabyUploadListRelationTagById(updateReqVO.getId(), BeanUtils.toBean(updateReqVO, BabyUploadListRelationTagDO.class));
        return success(true);
    }
    @DeleteMapping("/deleteById")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        babyUploadListRelationTagService.deleteBabyUploadListRelationTag(id);
        return success(true);
    }
    @GetMapping("/get")
    public CommonResult<BabyUploadListRelationTagRespVO> get(@RequestParam("id") Integer id) {
        BabyUploadListRelationTagDO babyUploadListRelationTag = babyUploadListRelationTagService.getBabyUploadListRelationTag(id);
        return CommonResultUtils.wrapEmptyObjResult(babyUploadListRelationTag, () ->{
            return BeanUtils.toBean(babyUploadListRelationTag, BabyUploadListRelationTagRespVO.class);
        });
    }
    @GetMapping("/page")
    public CommonResult<PageResult<BabyUploadListRelationTagRespVO>> page(@Valid BabyUploadListRelationTagPageReqVO pageReqVO) {
        PageResult<BabyUploadListRelationTagDO> pageResult = babyUploadListRelationTagService.getBabyUploadListRelationTagPage(BeanUtils.toBean(pageReqVO, BabyUploadListRelationTagPageReqBO.class));
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, BabyUploadListRelationTagRespVO.class));
    }

}
