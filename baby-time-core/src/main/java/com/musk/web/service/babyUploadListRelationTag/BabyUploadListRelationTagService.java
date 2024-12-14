package com.musk.web.service.babyUploadListRelationTag;

import com.baomidou.mybatisplus.extension.service.IService;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.BabyUploadListRelationTagDO;
import com.musk.web.dal.dataobject.babyUploadListRelationTag.bo.BabyUploadListRelationTagPageReqBO;
import jakarta.validation.*;
import org.example.musk.common.pojo.db.PageResult;

/**
 * 宝宝上传记录与标签关联 Service 接口
 *
 * @author 代码生成器
 */
public interface BabyUploadListRelationTagService extends IService<BabyUploadListRelationTagDO> {

    /**
     * 创建宝宝上传记录与标签关联
     *
     * @param babyUploadListRelationTagDO 创建信息
     * @return ID
     */
    Integer createBabyUploadListRelationTag(@Valid BabyUploadListRelationTagDO babyUploadListRelationTagDO);
    /**
     * 更��宝宝上传记录与标签关联
     *
     * @param updateBabyUploadListRelationTag 更新信息
     */
    void updateBabyUploadListRelationTagById(Integer id, @Valid BabyUploadListRelationTagDO updateBabyUploadListRelationTag);
    /**
     * 删除宝宝上传记录与标签关联
     *
     * @param id 编号
     */
    void deleteBabyUploadListRelationTag(Integer id);
    /**
     * 获得宝宝上传记录与标签关联
     *
     * @param id 编号
     * @return 宝宝上传记录与标签关联信息
     */
    BabyUploadListRelationTagDO getBabyUploadListRelationTag(Integer id);
    /**
     * 宝宝上传记录与标签关联分页查询
     *
     * @param pageReqBO 分页查询参数
     * @return 宝宝上传记录与标签关联分页数据
     */
    PageResult<BabyUploadListRelationTagDO> getBabyUploadListRelationTagPage(BabyUploadListRelationTagPageReqBO pageReqBO);

}