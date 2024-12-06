package com.musk.web.dal.mysql.familyMemberRelation;

import com.musk.web.dal.dataobject.familyMemberRelation.FamilyMemberRelationDO;
import com.musk.web.dal.dataobject.familyMemberRelation.bo.FamilyMemberRelationPageReqBO;
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
public interface FamilyMemberRelationMapper extends BaseMapperX<FamilyMemberRelationDO> {

    default PageResult<FamilyMemberRelationDO> selectPage(FamilyMemberRelationPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FamilyMemberRelationDO>()

.eqIfPresent(FamilyMemberRelationDO::getFamilyId, reqVO.getFamilyId())
                .eqIfPresent(FamilyMemberRelationDO::getMemberId, reqVO.getMemberId())
                .betweenIfPresent(FamilyMemberRelationDO::getCreateTime, reqVO.getCreateTime()[0], reqVO.getCreateTime()[1])
                .orderByDesc(FamilyMemberRelationDO::getId));
    }

}
