package com.musk.web.service.uploadlist;

import com.musk.web.controller.uploadlist.vo.UploadListPageReqVO;
import com.musk.web.controller.uploadlist.vo.UploadListAddReqVO;
import com.musk.web.dal.dataobject.uploadlist.UploadListDO;
import jakarta.validation.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.musk.common.pojo.db.PageResult;


/**
 * 上传记录 Service 接口
 *
 * @author 马斯克源码
 */
public interface UploadListService extends IService<UploadListDO>{

    /**
     * 创建上传记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createUploadList(@Valid UploadListAddReqVO createReqVO);


    /**
     * 删除上传记录
     *
     * @param id 编号
     */
    void deleteUploadList(Integer id);

    /**
     * 获得上传记录
     *
     * @param id 编号
     * @return 上传记录
     */
    UploadListDO getUploadList(Integer id);

    /**
     * 获得上传记录分页
     *
     * @param pageReqVO 分页查询
     * @return 上传记录分页
     */
    PageResult<UploadListDO> getUploadListPage(UploadListPageReqVO pageReqVO);

}
