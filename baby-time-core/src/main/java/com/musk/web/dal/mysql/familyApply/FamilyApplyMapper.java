package com.musk.web.dal.mysql.familyApply;

import com.musk.web.dal.dataobject.familyApply.FamilyApplyDO;
import com.musk.web.dal.dataobject.familyApply.bo.FamilyApplyPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * 家庭申请 Mapper
 *
 * @author 代码生成器
 */
@Mapper
public interface FamilyApplyMapper extends BaseMapperX<FamilyApplyDO> {

    default PageResult<FamilyApplyDO> selectPage(FamilyApplyPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FamilyApplyDO>()
                .eqIfPresent(FamilyApplyDO::getApplyFamilyId, reqVO.getApplyFamilyId())
                .likeIfPresent(FamilyApplyDO::getApplyFamilyCode, reqVO.getApplyFamilyCode())
                .eqIfPresent(FamilyApplyDO::getApplyId, reqVO.getApplyId())
                .eqIfPresent(FamilyApplyDO::getApplyStatus, reqVO.getApplyStatus())
                .likeIfPresent(FamilyApplyDO::getFailReason, reqVO.getFailReason())
                .betweenIfPresent(FamilyApplyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FamilyApplyDO::getId));
    }

}
