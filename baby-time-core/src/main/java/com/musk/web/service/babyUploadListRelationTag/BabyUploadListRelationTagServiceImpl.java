package com.musk.web.service.babyUploadListRelationTag;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.BabyUploadListRelationTagDO;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.bo.BabyUploadListRelationTagPageReqBO;
import com.musk.web.dal.mysql.babyUploadListRelationTag.BabyUploadListRelationTagMapper;
import com.musk.web.exception.BusinessExceptionEnum;
import com.musk.web.service.babyUploadListRelationTag.BabyUploadListRelationTagService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.exception.BusinessException;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 宝宝上传记录与标签关联 Service 实现类
 *
 * @author 代码生成器
 */
@Service
@Validated
@Slf4j
public class BabyUploadListRelationTagServiceImpl extends ServiceImpl<BabyUploadListRelationTagMapper, BabyUploadListRelationTagDO> implements BabyUploadListRelationTagService {

    @Override
    public Integer createBabyUploadListRelationTag(@Valid BabyUploadListRelationTagDO babyUploadListRelationTag) {
        this.baseMapper.insert(babyUploadListRelationTag);
        return babyUploadListRelationTag.getId();
    }
    @Override
    public void updateBabyUploadListRelationTagById(Integer id, @Valid BabyUploadListRelationTagDO babyUploadListRelationTag) {
        // 校验存在
        validateBabyUploadListRelationTagExists(id);
        // 更新
        this.baseMapper.updateById(babyUploadListRelationTag);
    }
    @Override
    public void deleteBabyUploadListRelationTag(Integer id) {
        // 校验存在
        validateBabyUploadListRelationTagExists(id);
        // 删除
        this.baseMapper.deleteById(id);
    }
    private void validateBabyUploadListRelationTagExists(Integer id) {
        if (getBabyUploadListRelationTag(id) == null) {
            throw new RuntimeException("未获取到宝宝上传记录与标签关联信息");
        }
    }
    @Override
    public BabyUploadListRelationTagDO getBabyUploadListRelationTag(Integer id) {
        return this.baseMapper.selectById(id);
    }
    @Override
    public PageResult<BabyUploadListRelationTagDO> getBabyUploadListRelationTagPage(BabyUploadListRelationTagPageReqBO pageReqBO) {
        return this.baseMapper.selectPage(pageReqBO);
    }

    @Override
    public List<BabyUploadListRelationTagDO> queryBabyUploadListRelationTag(List<Integer> uploadIds) {
        return this.baseMapper.selectList(new LambdaQueryWrapperX<BabyUploadListRelationTagDO>().in(BabyUploadListRelationTagDO::getUploadListId,uploadIds));
    }

    @Override
    public boolean existsBabyUploadListRelationTagServiceByTagId(Integer uploadListId,Integer tagId) {
        return this.baseMapper.exists(new LambdaQueryWrapperX<BabyUploadListRelationTagDO>()
                .eq(BabyUploadListRelationTagDO::getUploadListId,uploadListId)
                .eq(BabyUploadListRelationTagDO::getBabyUploadTagId,tagId)
        );
    }

    @Override
    public boolean uploadListCancelTag(Integer uploadListId, Integer tagId) {
        BabyUploadListRelationTagDO babyUploadListRelationTagDO = this.baseMapper.selectOne(new LambdaQueryWrapperX<BabyUploadListRelationTagDO>()
                .eq(BabyUploadListRelationTagDO::getUploadListId, uploadListId)
                .eq(BabyUploadListRelationTagDO::getBabyUploadTagId, tagId)
        );
        if (null == babyUploadListRelationTagDO) {
            throw new BusinessException(BusinessExceptionEnum.TAG_RELATION_NOT_EXISTS);
        }
        deleteBabyUploadListRelationTag(babyUploadListRelationTagDO.getId());
        return true;
    }
}
