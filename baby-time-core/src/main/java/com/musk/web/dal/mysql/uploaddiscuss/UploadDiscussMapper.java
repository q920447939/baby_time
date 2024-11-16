package com.musk.web.dal.mysql.uploaddiscuss;

import com.musk.web.dal.dataobject.uploaddiscuss.UploadDiscussDO;
import com.musk.web.dal.dataobject.uploaddiscuss.bo.UploadDiscussPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

import java.util.*;


/**
 * 讨论记录 Mapper
 *
 * @author 马斯克源码
 */
@Mapper
public interface UploadDiscussMapper extends BaseMapperX<UploadDiscussDO> {

    default PageResult<UploadDiscussDO> selectPage(UploadDiscussPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<UploadDiscussDO>()
                .eqIfPresent(UploadDiscussDO::getBabyId, reqVO.getBabyId())
                .eqIfPresent(UploadDiscussDO::getUploadId, reqVO.getUploadId())
                .eqIfPresent(UploadDiscussDO::getContent, reqVO.getContent())
                .betweenIfPresent(UploadDiscussDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(UploadDiscussDO::getId));
    }

}
