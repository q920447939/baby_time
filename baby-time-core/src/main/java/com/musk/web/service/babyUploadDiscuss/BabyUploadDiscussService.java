package com.musk.web.service.babyUploadDiscuss;

import com.baomidou.mybatisplus.extension.service.IService;
import com.musk.web.dal.dataobject.babyUploadDiscuss.BabyUploadDiscussDO;
import com.musk.web.dal.dataobject.babyUploadDiscuss.bo.BabyUploadDiscussPageReqBO;
import jakarta.validation.*;
import org.example.musk.common.pojo.db.PageResult;

/**
 *  Service 接口
 *
 * @author 代码生成器
 */
public interface BabyUploadDiscussService extends IService<BabyUploadDiscussDO> {

    /**
     * 创建
     *
     * @param babyUploadDiscussDO 创建信息
     * @return ID
     */
    Integer createBabyUploadDiscuss(@Valid BabyUploadDiscussDO babyUploadDiscussDO);
    /**
     * 更新
     *
     * @param updateBabyUploadDiscuss 更新信息
     */
    void updateBabyUploadDiscussById(Integer id, @Valid BabyUploadDiscussDO updateBabyUploadDiscuss);
    /**
     * 删除
     *
     * @param id 编号
     */
    void deleteBabyUploadDiscuss(Integer id);
    /**
     * 获得
     *
     * @param id 编号
     * @return 
     */
    BabyUploadDiscussDO getBabyUploadDiscuss(Integer id);
    /**
     * 获得分
     *
     * @param pageReqBO 分页查询
     * @return 分页
     */
    PageResult<BabyUploadDiscussDO> getBabyUploadDiscussPage(BabyUploadDiscussPageReqBO pageReqBO);

}