package com.musk.web.service.uploadlist;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.controller.uploadlist.vo.UploadListPageReqVO;
import com.musk.web.controller.uploadlist.vo.UploadListAddReqVO;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.BabyUploadListRelationTagDO;
import com.musk.web.dal.dataobject.uploadlist.UploadListDO;
import com.musk.web.dal.dataobject.uploadlist.bo.UploadListPageReqBO;
import com.musk.web.dal.mysql.uploadlist.UploadListMapper;
import com.musk.web.exception.BusinessExceptionEnum;
import com.musk.web.service.babyUploadListRelationTag.BabyUploadListRelationTagService;
import com.musk.web.service.uploadimage.UploadImageService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.exception.BusinessException;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.plugin.lock.config.anno.PluginLockSafeExec;
import org.example.musk.plugin.lock.enums.LockGroupEnums;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import static com.musk.web.exception.BusinessExceptionEnum.TAG_IS_RELATION;


/**
 * 上传记录 Service 实现类
 *
 * @author 马斯克源码
 */
@Service
@Validated
@Slf4j
public class UploadListServiceImpl extends ServiceImpl<UploadListMapper, UploadListDO> implements UploadListService {

    @Resource
    private UploadListMapper uploadListMapper;
    @Resource
    private UploadImageService uploadImageService;

    @Override
    public Integer createUploadList(UploadListAddReqVO createReqVO) {
        // 插入
        UploadListDO uploadList = BeanUtils.toBean(createReqVO, UploadListDO.class);
        if (uploadListMapper.insert(uploadList) > 0) {
            uploadImageService.createUploadImage(createReqVO.getUploadImageAddReqVO(),uploadList.getId());
            return uploadList.getId();
        }
        // 返回
        return uploadList.getId();
    }



    @Override
    public void deleteUploadList(Integer id) {
        // 校验存在
        validateUploadListExists(id);
        // 删除
        uploadListMapper.deleteById(id);
    }

    private void validateUploadListExists(Integer id) {
    /**
        if (uploadListMapper.selectById(id) == null) {
            throw exception(UPLOAD_LIST_NOT_EXISTS);
        }
        */
    }

    @Override
    public UploadListDO getUploadList(Integer id) {
        return uploadListMapper.selectById(id);
    }

    @Override
    public PageResult<UploadListDO> getUploadListPage(UploadListPageReqVO pageReqVO) {
        UploadListPageReqBO uploadListPageReqBO = BeanUtils.toBean(pageReqVO, UploadListPageReqBO.class);
        if (null != pageReqVO.getIsCollect()) {
            uploadListPageReqBO.setIsCollect(pageReqVO.getIsCollect() ? (byte) 1 : 0);
        }
        return uploadListMapper.selectPage(uploadListPageReqBO);
    }


    @Override
    public boolean markLike(Integer id, boolean isCollect) {
        UploadListDO uploadList = getUploadList(id);
        if (null == uploadList) {
            return false;
        }
        UploadListDO update = new UploadListDO();
        update.setIsCollect(isCollect);
        update.setId(id);
        return uploadListMapper.updateById(update) > 0 ;
    }

    @Resource
    private BabyUploadListRelationTagService babyUploadListRelationTagService;

    @Override
    @PluginLockSafeExec
    public boolean relationTag(Integer uploadListId, Integer tagId) {
        boolean b = babyUploadListRelationTagService.existsBabyUploadListRelationTagServiceByTagId(uploadListId,tagId);
        if (b) {
            throw new BusinessException(TAG_IS_RELATION);
        }
        @Valid BabyUploadListRelationTagDO info = new BabyUploadListRelationTagDO();
        info.setUploadListId(uploadListId);
        info.setBabyUploadTagId(tagId);
        return babyUploadListRelationTagService.createBabyUploadListRelationTag(info) > 0;
    }

    @Override
    @PluginLockSafeExec
    public boolean uploadListCancelTag(Integer uploadListId, Integer tagId) {
        return babyUploadListRelationTagService.uploadListCancelTag(uploadListId,tagId);
    }
}
