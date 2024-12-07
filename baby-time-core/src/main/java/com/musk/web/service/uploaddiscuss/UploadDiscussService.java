package com.musk.web.service.uploaddiscuss;

import java.util.*;

import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussPageReqVO;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussAddReqVO;
import com.musk.web.dal.dataobject.uploaddiscuss.UploadDiscussDO;
import jakarta.validation.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.musk.common.pojo.db.PageResult;


/**
 * 讨论记录 Service 接口
 *
 * @author 马斯克源码
 */
public interface UploadDiscussService extends IService<UploadDiscussDO>{

    /**
     * 创建讨论记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createUploadDiscuss(@Valid UploadDiscussAddReqVO createReqVO);


    /**
     * 删除讨论记录
     *
     * @param id 编号
     */
    void deleteUploadDiscuss(Integer id);

    /**
     * 获得讨论记录
     *
     * @param id 编号
     * @return 讨论记录
     */
    UploadDiscussDO getUploadDiscuss(Integer id);

    /**
     * 获得讨论记录分页
     *
     * @param pageReqVO 分页查询
     * @return 讨论记录分页
     */
    PageResult<UploadDiscussDO> getUploadDiscussPage(UploadDiscussPageReqVO pageReqVO);

    List<UploadDiscussDO> queryDiscussByUploadIds(List<Integer> uploadIds);
}
