package com.musk.web.dal.mysql.uploadlist;

import java.util.*;

import com.musk.web.dal.dataobject.uploadlist.UploadListDO;
import com.musk.web.dal.dataobject.uploadlist.bo.UploadListPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * 上传记录 Mapper
 *
 * @author 马斯克源码
 */
@Mapper
public interface UploadListMapper extends BaseMapperX<UploadListDO> {

    default PageResult<UploadListDO> selectPage(UploadListPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UploadListDO>()
                .eqIfPresent(UploadListDO::getBabyId, reqVO.getBabyId())
                .eqIfPresent(UploadListDO::getUploadType, reqVO.getUploadType())
                .eqIfPresent(UploadListDO::getUploadUser, reqVO.getUploadUser())
                .betweenIfPresent(UploadListDO::getUploadTime, reqVO.getUploadTime())
                .eqIfPresent(UploadListDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(UploadListDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UploadListDO::getId));
    }

}
