package com.musk.web.service.babyUploadTag;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.dal.dataobject.babyUploadTag.BabyUploadTagDO;
import com.musk.web.dal.dataobject.babyUploadTag.bo.BabyUploadTagPageReqBO;
import com.musk.web.dal.mysql.babyUploadTag.BabyUploadTagMapper;
import com.musk.web.service.babyUploadTag.BabyUploadTagService;
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
 * 上传文件标签 Service 实现类
 *
 * @author 代码生成器
 */
@Service
@Validated
@Slf4j
public class BabyUploadTagServiceImpl extends ServiceImpl<BabyUploadTagMapper, BabyUploadTagDO> implements BabyUploadTagService {

    @Override
    public Integer createBabyUploadTag(@Valid BabyUploadTagDO babyUploadTag) {
        this.baseMapper.insert(babyUploadTag);
        return babyUploadTag.getId();
    }
    @Override
    public void updateBabyUploadTagById(Integer id, @Valid BabyUploadTagDO babyUploadTag) {
        // 校验存在
        validateBabyUploadTagExists(id);
        // 更新
        this.baseMapper.updateById(babyUploadTag);
    }
    @Override
    public void deleteBabyUploadTag(Integer id) {
        // 校验存在
        validateBabyUploadTagExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }
    private void validateBabyUploadTagExists(Integer id) {
        if (getBabyUploadTag(id) == null) {
            throw new RuntimeException("未获取到上传文件标签信息");
        }
    }
    @Override
    public BabyUploadTagDO getBabyUploadTag(Integer id) {
        return this.baseMapper.selectById(id);
    }
    @Override
    public PageResult<BabyUploadTagDO> getBabyUploadTagPage(BabyUploadTagPageReqBO pageReqBO) {
        return this.baseMapper.selectPage(pageReqBO);
    }

    @Override
    public List<BabyUploadTagDO> getBabyUploadTagAll(Integer babyId) {
        return this.baseMapper.selectList(new LambdaQueryWrapperX<BabyUploadTagDO>().eq(BabyUploadTagDO::getBabyId,babyId));
    }
}
