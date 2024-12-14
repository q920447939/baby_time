package com.musk.web.service.uploadimage;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.controller.uploadimage.vo.UploadImagePageReqVO;
import com.musk.web.controller.uploadimage.vo.UploadImageAddReqVO;
import com.musk.web.dal.dataobject.uploadimage.UploadImageDO;
import com.musk.web.dal.dataobject.uploadimage.bo.UploadImagePageReqBO;
import com.musk.web.dal.mysql.uploadimage.UploadImageMapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;

import lombok.extern.slf4j.Slf4j;


/**
 * 上传图片 Service 实现类
 *
 * @author 马斯克源码
 */
@Service
@Validated
@Slf4j
public class UploadImageServiceImpl extends ServiceImpl<UploadImageMapper, UploadImageDO> implements UploadImageService {

    @Resource
    private UploadImageMapper uploadImageMapper;

    @Override
    public boolean createUploadImage(UploadImageAddReqVO createReqVO,Integer uploadId) {
        List<UploadImageDO> list = new ArrayList<>();
        for (String imageUrl : createReqVO.getImageUrls()) {
            UploadImageDO uploadImageDO = new UploadImageDO();
            uploadImageDO.setBabyId(createReqVO.getBabyId());
            uploadImageDO.setUploadId(uploadId);
            uploadImageDO.setImageUrl(imageUrl);
            list.add(uploadImageDO);
        }
        // 插入
        uploadImageMapper.insertBatch(list);
        // 返回
        return true;
    }



    @Override
    public void deleteUploadImage(Integer id) {
        // 校验存在
        validateUploadImageExists(id);
        // 删除
        uploadImageMapper.deleteById(id);
    }

    private void validateUploadImageExists(Integer id) {
    /**
        if (uploadImageMapper.selectById(id) == null) {
            throw exception(UPLOAD_IMAGE_NOT_EXISTS);
        }
        */
    }

    @Override
    public UploadImageDO getUploadImage(Integer id) {
        return uploadImageMapper.selectById(id);
    }

    @Override
    public PageResult<UploadImageDO> getUploadImagePage(UploadImagePageReqVO pageReqVO) {
        return uploadImageMapper.selectPage(BeanUtils.toBean(pageReqVO, UploadImagePageReqBO.class));
    }


    @Override
    public List<UploadImageDO> queryUploadImageByUploadIds(List<Integer> uploadIds) {
        return this.baseMapper.selectList(new LambdaQueryWrapperX<UploadImageDO>().in(UploadImageDO::getUploadId,uploadIds));
    }
}
