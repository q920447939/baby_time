package com.musk.web.service.info;

import com.musk.web.controller.baby.vo.BabyInfoPageReqVO;
import com.musk.web.controller.baby.vo.BabyInfoSaveReqVO;
import com.musk.web.dal.dataobject.info.BabyInfoDO;
import jakarta.validation.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.musk.common.pojo.db.PageResult;

import java.util.List;


/**
 * 宝宝信息 Service 接口
 *
 * @author 马斯克源码
 */
public interface BabyInfoService extends IService<BabyInfoDO>{

    /**
     * 创建宝宝信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createInfo(@Valid BabyInfoSaveReqVO createReqVO);

    /**
     * 更新宝宝信息
     *
     * @param updateReqVO 更新信息
     */
    void updateInfo(@Valid BabyInfoSaveReqVO updateReqVO);

    /**
     * 删除宝宝信息
     *
     * @param id 编号
     */
    void deleteInfo(Integer id);

    /**
     * 获得宝宝信息
     *
     * @param id 编号
     * @return 宝宝信息
     */
    BabyInfoDO getInfo(Integer id);

    /**
     * 获得宝宝信息分页
     *
     * @param pageReqVO 分页查询
     * @return 宝宝信息分页
     */
    PageResult<BabyInfoDO> getInfoPage(BabyInfoPageReqVO pageReqVO);

    List<BabyInfoDO> fetchAllBaby(Integer familyId);
}
