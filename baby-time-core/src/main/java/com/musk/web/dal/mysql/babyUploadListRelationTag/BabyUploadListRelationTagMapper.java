package com.musk.web.dal.mysql.babyUploadListRelationTag;

import com.musk.web.dal.dataobject.babyUploadListRelationTag.BabyUploadListRelationTagDO;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.bo.BabyUploadListRelationTagPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * 宝宝上传记录与标签关联 Mapper
 *
 * @author 代码生成器
 */
@Mapper
public interface BabyUploadListRelationTagMapper extends BaseMapperX<BabyUploadListRelationTagDO> {

    default PageResult<BabyUploadListRelationTagDO> selectPage(BabyUploadListRelationTagPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BabyUploadListRelationTagDO>()
                
.eqIfPresent(BabyUploadListRelationTagDO::getBabyId, reqVO.getBabyId()) 
                .eqIfPresent(BabyUploadListRelationTagDO::getBabyUploadTagId, reqVO.getBabyUploadTagId()) 
                .betweenIfPresent(BabyUploadListRelationTagDO::getCreateTime, reqVO.getCreateTime()[0], reqVO.getCreateTime()[1]) 
                .orderByDesc(BabyUploadListRelationTagDO::getId));
    }

}