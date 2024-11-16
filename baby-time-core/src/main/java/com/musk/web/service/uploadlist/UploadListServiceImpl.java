package com.musk.web.service.uploadlist;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.controller.uploadlist.vo.UploadListPageReqVO;
import com.musk.web.controller.uploadlist.vo.UploadListSaveReqVO;
import com.musk.web.dal.dataobject.uploadlist.UploadListDO;
import com.musk.web.dal.dataobject.uploadlist.bo.UploadListPageReqBO;
import com.musk.web.dal.mysql.uploadlist.UploadListMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


import lombok.extern.slf4j.Slf4j;


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

    @Override
    public Integer createUploadList(UploadListSaveReqVO createReqVO) {
        // 插入
        UploadListDO uploadList = BeanUtils.toBean(createReqVO, UploadListDO.class);
        uploadListMapper.insert(uploadList);
        // 返回
        return uploadList.getId();
    }

    @Override
    public void updateUploadList(UploadListSaveReqVO updateReqVO) {
        // 校验存在
        validateUploadListExists(updateReqVO.getId());
        // 更新
        UploadListDO updateObj = BeanUtils.toBean(updateReqVO, UploadListDO.class);
        uploadListMapper.updateById(updateObj);
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
        return uploadListMapper.selectPage(BeanUtils.toBean(pageReqVO, UploadListPageReqBO.class));
    }

}
