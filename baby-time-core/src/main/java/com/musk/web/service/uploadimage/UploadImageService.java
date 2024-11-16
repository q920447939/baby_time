package com.musk.web.service.uploadimage;

import java.util.*;

import com.musk.web.controller.uploadimage.vo.UploadImagePageReqVO;
import com.musk.web.controller.uploadimage.vo.UploadImageSaveReqVO;
import com.musk.web.dal.dataobject.uploadimage.UploadImageDO;
import jakarta.validation.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.musk.common.pojo.db.PageResult;


/**
 * 上传图片 Service 接口
 *
 * @author 马斯克源码
 */
public interface UploadImageService extends IService<UploadImageDO>{

    /**
     * 创建上传图片
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createUploadImage(@Valid UploadImageSaveReqVO createReqVO);

    /**
     * 更新上传图片
     *
     * @param updateReqVO 更新信息
     */
    void updateUploadImage(@Valid UploadImageSaveReqVO updateReqVO);

    /**
     * 删除上传图片
     *
     * @param id 编号
     */
    void deleteUploadImage(Integer id);

    /**
     * 获得上传图片
     *
     * @param id 编号
     * @return 上传图片
     */
    UploadImageDO getUploadImage(Integer id);

    /**
     * 获得上传图片分页
     *
     * @param pageReqVO 分页查询
     * @return 上传图片分页
     */
    PageResult<UploadImageDO> getUploadImagePage(UploadImagePageReqVO pageReqVO);

    List<UploadImageDO> queryUploadImageByUploadIds(List<Integer> uploadIds);
}
