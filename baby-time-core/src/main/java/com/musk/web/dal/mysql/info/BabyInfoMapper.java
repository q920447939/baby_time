package com.musk.web.dal.mysql.info;

import java.util.*;

import com.musk.web.dal.dataobject.info.BabyInfoDO;
import com.musk.web.dal.dataobject.info.bo.BabyInfoPageReqBO;
import org.apache.ibatis.annotations.Mapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.mapper.BaseMapperX;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;

/**
 * 宝宝信息 Mapper
 *
 * @author 马斯克源码
 */
@Mapper
public interface BabyInfoMapper extends BaseMapperX<BabyInfoDO> {

    default PageResult<BabyInfoDO> selectPage(BabyInfoPageReqBO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BabyInfoDO>()
                .likeIfPresent(BabyInfoDO::getName, reqVO.getName())
                .eqIfPresent(BabyInfoDO::getAvatarUrl, reqVO.getAvatarUrl())
                .eqIfPresent(BabyInfoDO::getSex, reqVO.getSex())
                .eqIfPresent(BabyInfoDO::getBirthday, reqVO.getBirthday())
                .betweenIfPresent(BabyInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BabyInfoDO::getId));
    }

}
