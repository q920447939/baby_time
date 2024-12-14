package com.musk.web.service.uploaddiscuss;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussPageReqVO;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussAddReqVO;
import com.musk.web.dal.dataobject.uploaddiscuss.UploadDiscussDO;
import com.musk.web.dal.dataobject.uploaddiscuss.bo.UploadDiscussPageReqBO;
import com.musk.web.dal.mysql.uploaddiscuss.UploadDiscussMapper;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import lombok.extern.slf4j.Slf4j;


/**
 * 讨论记录 Service 实现类
 *
 * @author 马斯克源码
 */
@Service
@Validated
@Slf4j
public class UploadDiscussServiceImpl extends ServiceImpl<UploadDiscussMapper, UploadDiscussDO> implements UploadDiscussService {

    @Resource
    private UploadDiscussMapper uploadDiscussMapper;

    @Override
    public Integer createUploadDiscuss(UploadDiscussAddReqVO createReqVO) {
        // 插入
        UploadDiscussDO uploadDiscuss = BeanUtils.toBean(createReqVO, UploadDiscussDO.class);
        uploadDiscuss.setDiscussMemberId(ThreadLocalTenantContext.getMemberId());
        uploadDiscussMapper.insert(uploadDiscuss);
        // 返回
        return uploadDiscuss.getId();
    }
    @Override
    public void deleteUploadDiscuss(Integer id) {
        // 校验存在
        validateUploadDiscussExists(id);
        // 删除
        uploadDiscussMapper.deleteById(id);
    }

    private void validateUploadDiscussExists(Integer id) {
    /**
        if (uploadDiscussMapper.selectById(id) == null) {
            throw exception(UPLOAD_DISCUSS_NOT_EXISTS);
        }
        */
    }

    @Override
    public UploadDiscussDO getUploadDiscuss(Integer id) {
        return uploadDiscussMapper.selectById(id);
    }

    @Override
    public PageResult<UploadDiscussDO> getUploadDiscussPage(UploadDiscussPageReqVO pageReqVO) {
        return uploadDiscussMapper.selectPage(BeanUtils.toBean(pageReqVO, UploadDiscussPageReqBO.class));
    }

    @Override
    public List<UploadDiscussDO> queryDiscussByUploadIds(List<Integer> uploadIds) {
        return uploadDiscussMapper.selectList(new LambdaQueryWrapperX<UploadDiscussDO>().in(UploadDiscussDO::getUploadId, uploadIds));
    }
}
