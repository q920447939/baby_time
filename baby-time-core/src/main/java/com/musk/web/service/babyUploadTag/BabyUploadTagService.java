package com.musk.web.service.babyUploadTag;

import com.baomidou.mybatisplus.extension.service.IService;
import com.musk.web.dal.dataobject.babyUploadTag.BabyUploadTagDO;
import com.musk.web.dal.dataobject.babyUploadTag.bo.BabyUploadTagPageReqBO;
import jakarta.validation.*;
import org.example.musk.common.pojo.db.PageResult;

import java.util.List;

/**
 * 上传文件标签 Service 接口
 *
 * @author 代码生成器
 */
public interface BabyUploadTagService extends IService<BabyUploadTagDO> {

    /**
     * 创建上传文件标签
     *
     * @param babyUploadTagDO 创建信息
     * @return ID
     */
    Integer createBabyUploadTag(@Valid BabyUploadTagDO babyUploadTagDO);
    /**
     * 更��上传文件标签
     *
     * @param updateBabyUploadTag 更新信息
     */
    void updateBabyUploadTagById(Integer id, @Valid BabyUploadTagDO updateBabyUploadTag);
    /**
     * 删除上传文件标签
     *
     * @param id 编号
     */
    void deleteBabyUploadTag(Integer id);
    /**
     * 获得上传文件标签
     *
     * @param id 编号
     * @return 上传文件标签信息
     */
    BabyUploadTagDO getBabyUploadTag(Integer id);
    /**
     * 上传文件标签分页查询
     *
     * @param pageReqBO 分页查询参数
     * @return 上传文件标签分页数据
     */
    PageResult<BabyUploadTagDO> getBabyUploadTagPage(BabyUploadTagPageReqBO pageReqBO);

    List<BabyUploadTagDO> getBabyUploadTagAll(Integer babyId);

    List<BabyUploadTagDO> queryBabyUploadTag(List<Integer> tagIds);
}
