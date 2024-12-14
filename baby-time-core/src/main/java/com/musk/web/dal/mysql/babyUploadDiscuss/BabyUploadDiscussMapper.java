package com.musk.web.dal.mysql.babyUploadDiscuss;

import com.musk.web.dal.dataobject.babyUploadDiscuss.BabyUploadDiscussDO;
import com.musk.web.dal.dataobject.babyUploadDiscuss.bo.BabyUploadDiscussPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 *  Mapper
 *
 * @author 代码生成器
 */
@Mapper
public interface BabyUploadDiscussMapper extends BaseMapperX<BabyUploadDiscussDO> {

    default PageResult<BabyUploadDiscussDO> selectPage(BabyUploadDiscussPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BabyUploadDiscussDO>()
                
.eqIfPresent(BabyUploadDiscussDO::getBabyId, reqVO.getBabyId()) 
                .eqIfPresent(BabyUploadDiscussDO::getUploadId, reqVO.getUploadId()) 
                .eqIfPresent(BabyUploadDiscussDO::getDiscussMemberId, reqVO.getDiscussMemberId()) 
                .likeIfPresent(BabyUploadDiscussDO::getContent, reqVO.getContent()) 
                .betweenIfPresent(BabyUploadDiscussDO::getCreateTime, reqVO.getCreateTime()[0], reqVO.getCreateTime()[1]) 
                .orderByDesc(BabyUploadDiscussDO::getId));
    }

}