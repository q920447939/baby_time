package com.musk.web.service.babyUploadDiscuss;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.dal.dataobject.babyUploadDiscuss.BabyUploadDiscussDO;
import com.musk.web.dal.dataobject.babyUploadDiscuss.bo.BabyUploadDiscussPageReqBO;
import com.musk.web.dal.mysql.babyUploadDiscuss.BabyUploadDiscussMapper;
import com.musk.web.service.babyUploadDiscuss.BabyUploadDiscussService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 *  Service 实现类
 *
 * @author 代码生成器
 */
@Service
@Validated
@Slf4j
public class BabyUploadDiscussServiceImpl extends ServiceImpl<BabyUploadDiscussMapper, BabyUploadDiscussDO> implements BabyUploadDiscussService {

    @Override
    public Integer createBabyUploadDiscuss(@Valid BabyUploadDiscussDO babyUploadDiscuss) {
        this.baseMapper.insert(babyUploadDiscuss);
        return babyUploadDiscuss.getId();
    }
    @Override
    public void updateBabyUploadDiscussById(Integer id, @Valid BabyUploadDiscussDO babyUploadDiscuss) {
        // 校验存在
        validateBabyUploadDiscussExists(id);
        // 更新
        this.baseMapper.updateById(babyUploadDiscuss);
    }
    @Override
    public void deleteBabyUploadDiscuss(Integer id) {
        // 校验存在
        validateBabyUploadDiscussExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }
    private void validateBabyUploadDiscussExists(Integer id) {
        if (getBabyUploadDiscuss(id) == null) {
            throw new RuntimeException("未获取到信息");
        }
    }
    @Override
    public BabyUploadDiscussDO getBabyUploadDiscuss(Integer id) {
        return this.baseMapper.selectById(id);
    }
    @Override
    public PageResult<BabyUploadDiscussDO> getBabyUploadDiscussPage(BabyUploadDiscussPageReqBO pageReqBO) {
        return this.baseMapper.selectPage(pageReqBO);
    }

}