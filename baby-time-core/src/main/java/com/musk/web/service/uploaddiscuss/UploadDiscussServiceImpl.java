package com.musk.web.service.uploaddiscuss;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussPageReqVO;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussSaveReqVO;
import com.musk.web.dal.dataobject.uploaddiscuss.UploadDiscussDO;
import com.musk.web.dal.dataobject.uploaddiscuss.bo.UploadDiscussPageReqBO;
import com.musk.web.dal.mysql.uploaddiscuss.UploadDiscussMapper;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.example.musk.middleware.mybatisplus.mybatis.core.query.LambdaQueryWrapperX;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.dynamic.datasource.annotation.DS;


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
    public Integer createUploadDiscuss(UploadDiscussSaveReqVO createReqVO) {
        // 插入
        UploadDiscussDO uploadDiscuss = BeanUtils.toBean(createReqVO, UploadDiscussDO.class);
        uploadDiscussMapper.insert(uploadDiscuss);
        // 返回
        return uploadDiscuss.getId();
    }

    @Override
    public void updateUploadDiscuss(UploadDiscussSaveReqVO updateReqVO) {
        // 校验存在
        validateUploadDiscussExists(updateReqVO.getId());
        // 更新
        UploadDiscussDO updateObj = BeanUtils.toBean(updateReqVO, UploadDiscussDO.class);
        uploadDiscussMapper.updateById(updateObj);
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
