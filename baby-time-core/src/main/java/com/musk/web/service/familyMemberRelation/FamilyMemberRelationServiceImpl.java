package com.musk.web.service.familyMemberRelation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.dal.dataobject.familyMemberRelation.FamilyMemberRelationDO;
import com.musk.web.dal.dataobject.familyMemberRelation.bo.FamilyMemberRelationPageReqBO;
import com.musk.web.dal.mysql.familyMemberRelation.FamilyMemberRelationMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Service 实现类
 *
 * @author 代码生成器
 */
@Service
@Validated
@Slf4j
public class FamilyMemberRelationServiceImpl extends ServiceImpl<FamilyMemberRelationMapper, FamilyMemberRelationDO> implements FamilyMemberRelationService {

    @Override
    public Integer createFamilyMemberRelation(@Valid FamilyMemberRelationDO FamilyMemberRelation) {
        this.baseMapper.insert(FamilyMemberRelation);
        return FamilyMemberRelation.getId();
    }

    @Override
    public void updateFamilyMemberRelationById(Integer id, @Valid FamilyMemberRelationDO FamilyMemberRelation) {
        // 校验存在
        validateFamilyMemberRelationExists(id);
        // 更新
        this.baseMapper.updateById(FamilyMemberRelation);
    }

    @Override
    public void deleteFamilyMemberRelation(Integer id) {
        // 校验存在
        validateFamilyMemberRelationExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }

    private void validateFamilyMemberRelationExists(Integer id) {
        if (getFamilyMemberRelation(id) == null) {
            throw new RuntimeException("未获取到信息");
        }
    }

    @Override
    public FamilyMemberRelationDO getFamilyMemberRelation(Integer id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public PageResult<FamilyMemberRelationDO> getFamilyMemberRelationPage(FamilyMemberRelationPageReqBO pageReqBO) {
        return this.baseMapper.selectPage(pageReqBO);
    }

    @Override
    public List<FamilyMemberRelationDO> getFamilyMemberRelationByMemberId(Integer memberId) {
        return this.baseMapper.selectList(new LambdaQueryWrapperX<FamilyMemberRelationDO>().eq(FamilyMemberRelationDO::getMemberId,memberId));
    }
}
