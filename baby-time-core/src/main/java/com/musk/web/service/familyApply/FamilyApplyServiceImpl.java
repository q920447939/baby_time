package com.musk.web.service.familyApply;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.dal.dataobject.familyApply.FamilyApplyDO;
import com.musk.web.dal.dataobject.familyApply.bo.FamilyApplyPageReqBO;
import com.musk.web.dal.mysql.familyApply.FamilyApplyMapper;
import com.musk.web.service.familyApply.FamilyApplyService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 家庭申请 Service 实现类
 *
 * @author 代码生成器
 */
@Service
@Validated
@Slf4j
public class FamilyApplyServiceImpl extends ServiceImpl<FamilyApplyMapper, FamilyApplyDO> implements FamilyApplyService {

    @Override
    public Integer createFamilyApply(@Valid FamilyApplyDO familyApply) {
        this.baseMapper.insert(familyApply);
        return familyApply.getId();
    }
    @Override
    public void updateFamilyApplyById(Integer id, @Valid FamilyApplyDO familyApply) {
        // 校验存在
        validateFamilyApplyExists(id);
        // 更新
        this.baseMapper.updateById(familyApply);
    }
    @Override
    public void deleteFamilyApply(Integer id) {
        // 校验存在
        validateFamilyApplyExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }
    private void validateFamilyApplyExists(Integer id) {
        if (getFamilyApply(id) == null) {
            throw new RuntimeException("未获取到家庭申请信息");
        }
    }

    public List<FamilyApplyDO> getFamilyApplyByIds(List<Integer> ids) {
        return this.baseMapper.selectBatchIds(ids);
    }
    @Override
    public PageResult<FamilyApplyDO> getFamilyApplyPage(FamilyApplyPageReqBO pageReqBO) {
        return this.baseMapper.selectPage(pageReqBO);
    }

    @Override
    public boolean updateApplyStatus(Integer id, Integer applyStatus) {
        FamilyApplyDO update = new FamilyApplyDO();
        update.setApplyStatus(applyStatus);
        update.setId(id);
        return this.baseMapper.updateById(update) > 0 ;
    }
}
