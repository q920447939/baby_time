package com.musk.web.service.family;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.controller.family.vo.FamilyPageReqVO;
import com.musk.web.controller.family.vo.FamilySaveReqVO;
import com.musk.web.dal.dataobject.family.FamilyDO;
import com.musk.web.dal.dataobject.family.bo.FamilyPageReqBO;
import com.musk.web.dal.mysql.family.FamilyMapper;
import com.musk.web.event.familyMember.entity.FamilyMemberEventInfo;
import com.musk.web.exception.BusinessExceptionEnum;
import com.musk.web.service.familyMemberRelation.FamilyMemberRelationService;
import jakarta.validation.constraints.NotEmpty;
import org.example.musk.common.exception.BusinessException;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.example.musk.plugin.lock.config.anno.PluginLockSafeExec;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * 家庭 Service 实现类
 *
 * @author 马斯克源码
 */
@Service
@Validated
@Slf4j
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, FamilyDO> implements FamilyService {

    @Resource
    private FamilyMapper familyMapper;
    @Resource
    private ApplicationContext applicationContext;


    @Override
    @PluginLockSafeExec
    public Integer createFamily(FamilySaveReqVO createReqVO) {
        if (this.queryFamilyByName(createReqVO.getFamilyName())) {
            throw new BusinessException(BusinessExceptionEnum.FAMILY_IS_EXISTS);
        }
        // 插入
        FamilyDO family = BeanUtils.toBean(createReqVO, FamilyDO.class);
        family.setFamilyMemberCount(1);
        familyMapper.insert(family);
        applicationContext.publishEvent(FamilyMemberEventInfo.builder().familyId(family.getId()).memberId(family.getCreateId()).build());
        // 返回
        return family.getId();
    }

    private boolean queryFamilyByName(String familyName) {
        return this.baseMapper.exists(new LambdaQueryWrapperX<FamilyDO>().eq(FamilyDO::getFamilyName,familyName));
    }

    @Override
    public void updateFamily(FamilySaveReqVO updateReqVO) {
        // 校验存在
        validateFamilyExists(updateReqVO.getId());
        // 更新
        FamilyDO updateObj = BeanUtils.toBean(updateReqVO, FamilyDO.class);
        familyMapper.updateById(updateObj);
    }

    @Override
    public void deleteFamily(Integer id) {
        // 校验存在
        validateFamilyExists(id);
        // 删除
        familyMapper.deleteById(id);
        this.baseMapper.deleteById(id);
    }

    private void validateFamilyExists(Integer id) {
    /**
        if (familyMapper.selectById(id) == null) {
            throw exception(FAMILY_NOT_EXISTS);
        }
        */

    }

    @Override
    public FamilyDO getFamily(Integer id) {
        return familyMapper.selectById(id);
    }

    @Override
    public List<FamilyDO> getFamily(List<Integer> ids) {
        return familyMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<FamilyDO> getFamilyPage(FamilyPageReqVO pageReqVO) {
        return familyMapper.selectPage(BeanUtils.toBean(pageReqVO, FamilyPageReqBO.class));
    }

    @Override
    public FamilyDO getFamilyByFamilyCode(String applyFamilyCode) {
        return familyMapper.selectOne(new LambdaQueryWrapperX<FamilyDO>().eq(FamilyDO::getFamilyCode,applyFamilyCode));
    }
}
