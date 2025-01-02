package com.musk.web.service.info;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.controller.baby.vo.BabyInfoPageReqVO;
import com.musk.web.controller.baby.vo.BabyInfoSaveReqVO;
import com.musk.web.dal.dataobject.info.BabyInfoDO;
import com.musk.web.dal.dataobject.info.bo.BabyInfoPageReqBO;
import com.musk.web.dal.mysql.info.BabyInfoMapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;


import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * 宝宝信息 Service 实现类
 *
 * @author 马斯克源码
 */
@Service
@Validated
@Slf4j
public class BabyInfoServiceImpl extends ServiceImpl<BabyInfoMapper, BabyInfoDO> implements BabyInfoService {

    @Resource
    private BabyInfoMapper infoMapper;

    @Override
    public Integer createInfo(BabyInfoSaveReqVO createReqVO) {
        // 插入
        BabyInfoDO info = BeanUtils.toBean(createReqVO, BabyInfoDO.class);
        infoMapper.insert(info);
        // 返回
        return info.getId();
    }

    @Override
    public void updateInfo(BabyInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateInfoExists(updateReqVO.getId());
        // 更新
        BabyInfoDO updateObj = BeanUtils.toBean(updateReqVO, BabyInfoDO.class);
        infoMapper.updateById(updateObj);
    }

    @Override
    public void deleteInfo(Integer id) {
        // 校验存在
        validateInfoExists(id);
        // 删除
        infoMapper.deleteById(id);
    }

    private void validateInfoExists(Integer id) {
    /**
        if (infoMapper.selectById(id) == null) {
            throw exception(INFO_NOT_EXISTS);
        }
        */
    }

    @Override
    public BabyInfoDO getInfo(Integer id) {
        return infoMapper.selectById(id);
    }

    @Override
    public PageResult<BabyInfoDO> getInfoPage(BabyInfoPageReqVO pageReqVO) {
        return infoMapper.selectPage(BeanUtils.toBean(pageReqVO, BabyInfoPageReqBO.class));
    }

    @Override
    public List<BabyInfoDO> fetchAllBaby(Integer familyId) {
        return infoMapper.selectList(new LambdaQueryWrapperX<BabyInfoDO>().eq(BabyInfoDO::getFamilyId,familyId));
    }
}
