package com.musk.web.dal.mysql.family;

import java.util.*;

import com.musk.web.dal.dataobject.family.FamilyDO;
import com.musk.web.dal.dataobject.family.bo.FamilyPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * 家庭 Mapper
 *
 * @author 马斯克源码
 */
@Mapper
public interface FamilyMapper extends BaseMapperX<FamilyDO> {

    default PageResult<FamilyDO> selectPage(FamilyPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FamilyDO>()
                .likeIfPresent(FamilyDO::getFamilyName, reqVO.getFamilyName())
                .eqIfPresent(FamilyDO::getFamilyMemberCount, reqVO.getFamilyMemberCount())
                .betweenIfPresent(FamilyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FamilyDO::getId));
    }

}
