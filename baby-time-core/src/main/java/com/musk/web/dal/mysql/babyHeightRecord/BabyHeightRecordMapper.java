package com.musk.web.dal.mysql.babyHeightRecord;

import com.musk.web.dal.dataobject.babyHeightRecord.BabyHeightRecordDO;
import com.musk.web.dal.dataobject.babyHeightRecord.bo.BabyHeightRecordPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * Mapper
 *
 * @author 代码生成器
 */
@Mapper
public interface BabyHeightRecordMapper extends BaseMapperX<BabyHeightRecordDO> {

    default PageResult<BabyHeightRecordDO> selectPage(BabyHeightRecordPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BabyHeightRecordDO>()
                .eqIfPresent(BabyHeightRecordDO::getBabyId, reqVO.getBabyId())
                .eqIfPresent(BabyHeightRecordDO::getHeight, reqVO.getHeight())
                .eqIfPresent(BabyHeightRecordDO::getVersion, reqVO.getVersion())
                .betweenIfPresent(BabyHeightRecordDO::getRecordTime, reqVO.getRecordTime()[0], reqVO.getRecordTime()[1])
                .betweenIfPresent(BabyHeightRecordDO::getCreateTime, reqVO.getCreateTime()[0], reqVO.getCreateTime()[1])
                .orderByDesc(BabyHeightRecordDO::getRecordTime));
    }

}
