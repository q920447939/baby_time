package com.musk.web.service.babyHeightRecordStandard;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.dal.dataobject.babyHeightRecordStandard.BabyHeightRecordStandardDO;
import com.musk.web.dal.dataobject.babyHeightRecordStandard.bo.BabyHeightRecordStandardPageReqBO;
import com.musk.web.dal.mysql.babyHeightRecordStandard.BabyHeightRecordStandardMapper;
import com.musk.web.service.babyHeightRecordStandard.BabyHeightRecordStandardService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 *  Service 实现类
 *
 * @author 代码生成器
 */
@Service
@Validated
@Slf4j
public class BabyHeightRecordStandardServiceImpl extends ServiceImpl<BabyHeightRecordStandardMapper, BabyHeightRecordStandardDO> implements BabyHeightRecordStandardService {

    @Override
    public Integer createBabyHeightRecordStandard(@Valid BabyHeightRecordStandardDO babyHeightRecordStandard) {
        this.baseMapper.insert(babyHeightRecordStandard);
        return babyHeightRecordStandard.getId();
    }
    @Override
    public void updateBabyHeightRecordStandardById(Integer id, @Valid BabyHeightRecordStandardDO babyHeightRecordStandard) {
        // 校验存在
        validateBabyHeightRecordStandardExists(id);
        // 更新
        this.baseMapper.updateById(babyHeightRecordStandard);
    }
    @Override
    public void deleteBabyHeightRecordStandard(Integer id) {
        // 校验存在
        validateBabyHeightRecordStandardExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }
    private void validateBabyHeightRecordStandardExists(Integer id) {
        if (getBabyHeightRecordStandard(id) == null) {
            throw new RuntimeException("未获取到信息");
        }
    }
    @Override
    public BabyHeightRecordStandardDO getBabyHeightRecordStandard(Integer id) {
        return this.baseMapper.selectById(id);
    }
    @Override
    public PageResult<BabyHeightRecordStandardDO> getBabyHeightRecordStandardPage(BabyHeightRecordStandardPageReqBO pageReqBO) {
        return this.baseMapper.selectPage(pageReqBO);
    }

    @Override
    public List<BabyHeightRecordStandardDO> getBabyHeightRecordStandardByCountryCode(String countryCode,Short sex) {
        return  this.baseMapper.selectList(new LambdaQueryWrapperX<BabyHeightRecordStandardDO>()
                .eq(BabyHeightRecordStandardDO::getCountryCode,countryCode)
                .eq(BabyHeightRecordStandardDO::getBabySex,sex)
                .orderByAsc(BabyHeightRecordStandardDO::getId)
        );
    }
}
