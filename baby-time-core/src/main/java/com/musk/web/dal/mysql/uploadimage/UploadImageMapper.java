package com.musk.web.dal.mysql.uploadimage;

import java.util.*;

import com.musk.web.dal.dataobject.uploadimage.UploadImageDO;
import com.musk.web.dal.dataobject.uploadimage.bo.UploadImagePageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * 上传图片 Mapper
 *
 * @author 马斯克源码
 */
@Mapper
public interface UploadImageMapper extends BaseMapperX<UploadImageDO> {

    default PageResult<UploadImageDO> selectPage(UploadImagePageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UploadImageDO>()
                .eqIfPresent(UploadImageDO::getBabyId, reqVO.getBabyId())
                .eqIfPresent(UploadImageDO::getUploadId, reqVO.getUploadId())
                .eqIfPresent(UploadImageDO::getImageUrl, reqVO.getImageUrl())
                .betweenIfPresent(UploadImageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UploadImageDO::getId));
    }

}
