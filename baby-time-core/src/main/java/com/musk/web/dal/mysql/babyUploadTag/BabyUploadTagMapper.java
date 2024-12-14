package com.musk.web.dal.mysql.babyUploadTag;

import com.musk.web.dal.dataobject.babyUploadTag.BabyUploadTagDO;
import com.musk.web.dal.dataobject.babyUploadTag.bo.BabyUploadTagPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * 上传文件标签 Mapper
 *
 * @author 代码生成器
 */
@Mapper
public interface BabyUploadTagMapper extends BaseMapperX<BabyUploadTagDO> {

    default PageResult<BabyUploadTagDO> selectPage(BabyUploadTagPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BabyUploadTagDO>()
                
.eqIfPresent(BabyUploadTagDO::getBabyId, reqVO.getBabyId()) 
                .likeIfPresent(BabyUploadTagDO::getTagName, reqVO.getTagName()) 
                .betweenIfPresent(BabyUploadTagDO::getCreateTime, reqVO.getCreateTime()[0], reqVO.getCreateTime()[1]) 
                .orderByDesc(BabyUploadTagDO::getId));
    }

}