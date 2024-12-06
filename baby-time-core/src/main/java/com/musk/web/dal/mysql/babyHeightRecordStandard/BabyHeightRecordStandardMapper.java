package com.musk.web.dal.mysql.babyHeightRecordStandard;

import com.musk.web.dal.dataobject.babyHeightRecordStandard.BabyHeightRecordStandardDO;
import com.musk.web.dal.dataobject.babyHeightRecordStandard.bo.BabyHeightRecordStandardPageReqBO;
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
public interface BabyHeightRecordStandardMapper extends BaseMapperX<BabyHeightRecordStandardDO> {

    default PageResult<BabyHeightRecordStandardDO> selectPage(BabyHeightRecordStandardPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BabyHeightRecordStandardDO>()
                
.eqIfPresent(BabyHeightRecordStandardDO::getCountryCode, reqVO.getCountryCode()) 
                .eqIfPresent(BabyHeightRecordStandardDO::getBabySex, reqVO.getBabySex()) 
                .betweenIfPresent(BabyHeightRecordStandardDO::getCreateTime, reqVO.getCreateTime()[0], reqVO.getCreateTime()[1]) 
                .orderByDesc(BabyHeightRecordStandardDO::getId));
    }

}