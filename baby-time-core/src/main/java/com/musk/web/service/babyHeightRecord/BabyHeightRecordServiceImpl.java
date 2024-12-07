package com.musk.web.service.babyHeightRecord;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.dal.dataobject.babyHeightRecord.BabyHeightRecordDO;
import com.musk.web.dal.dataobject.babyHeightRecord.bo.BabyHeightRecordPageReqBO;
import com.musk.web.dal.mysql.babyHeightRecord.BabyHeightRecordMapper;
import com.musk.web.service.babyHeightRecord.BabyHeightRecordService;
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
public class BabyHeightRecordServiceImpl extends ServiceImpl<BabyHeightRecordMapper, BabyHeightRecordDO> implements BabyHeightRecordService {

    @Override
    public Integer createBabyHeightRecord(@Valid BabyHeightRecordDO babyHeightRecord) {
        BabyHeightRecordDO babyHeightRecordDO = this.baseMapper.selectOne(new LambdaQueryWrapperX<BabyHeightRecordDO>()
                .eq(BabyHeightRecordDO::getBabyId, babyHeightRecord.getBabyId())
                .orderByDesc(BabyHeightRecordDO::getVersion)
                .last("limit 1")
        );
        babyHeightRecord.setVersion(null == babyHeightRecordDO ? 1 : babyHeightRecordDO.getVersion() + 1);
        this.baseMapper.insert(babyHeightRecord);
        return babyHeightRecord.getId();
    }

    @Override
    public void updateBabyHeightRecordById(Integer id, @Valid BabyHeightRecordDO babyHeightRecord) {
        // 校验存在
        validateBabyHeightRecordExists(id);
        // 更新
        this.baseMapper.updateById(babyHeightRecord);
    }
    @Override
    public void deleteBabyHeightRecord(Integer id) {
        // 校验存在
        validateBabyHeightRecordExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }
    private void validateBabyHeightRecordExists(Integer id) {
        if (getBabyHeightRecord(id) == null) {
            throw new RuntimeException("未获取到信息");
        }
    }
    @Override
    public BabyHeightRecordDO getBabyHeightRecord(Integer id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public PageResult<BabyHeightRecordDO> getBabyHeightRecordPage(BabyHeightRecordPageReqBO pageReqBO) {
        return this.baseMapper.selectPage(pageReqBO);
    }


    @Override
    public List<BabyHeightRecordDO> getBabyHeightAllRecord(Integer babyId) {
        return this.baseMapper.selectList(new LambdaQueryWrapperX<BabyHeightRecordDO>().eq(BabyHeightRecordDO::getBabyId,babyId).orderByDesc(BabyHeightRecordDO::getRecordTime));
    }

    @Override
    public BabyHeightRecordDO getBabyHeightLatest(Integer babyId) {
        return this.baseMapper.selectOne(new LambdaQueryWrapperX<BabyHeightRecordDO>().eq(BabyHeightRecordDO::getBabyId,babyId).orderByDesc(BabyHeightRecordDO::getVersion).last("limit 1"));
    }
}
