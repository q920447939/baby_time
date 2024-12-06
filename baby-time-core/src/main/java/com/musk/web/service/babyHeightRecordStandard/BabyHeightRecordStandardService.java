package com.musk.web.service.babyHeightRecordStandard;

import com.baomidou.mybatisplus.extension.service.IService;
import com.musk.web.dal.dataobject.babyHeightRecordStandard.BabyHeightRecordStandardDO;
import com.musk.web.dal.dataobject.babyHeightRecordStandard.bo.BabyHeightRecordStandardPageReqBO;
import jakarta.validation.*;
import org.example.musk.common.pojo.db.PageResult;

import java.util.List;

/**
 *  Service 接口
 *
 * @author 代码生成器
 */
public interface BabyHeightRecordStandardService extends IService<BabyHeightRecordStandardDO> {

    /**
     * 创建
     *
     * @param babyHeightRecordStandardDO 创建信息
     * @return ID
     */
    Integer createBabyHeightRecordStandard(@Valid BabyHeightRecordStandardDO babyHeightRecordStandardDO);
    /**
     * 更新
     *
     * @param updateBabyHeightRecordStandard 更新信息
     */
    void updateBabyHeightRecordStandardById(Integer id, @Valid BabyHeightRecordStandardDO updateBabyHeightRecordStandard);
    /**
     * 删除
     *
     * @param id 编号
     */
    void deleteBabyHeightRecordStandard(Integer id);
    /**
     * 获得
     *
     * @param id 编号
     * @return
     */
    BabyHeightRecordStandardDO getBabyHeightRecordStandard(Integer id);
    /**
     * 获得分
     *
     * @param pageReqBO 分页查询
     * @return 分页
     */
    PageResult<BabyHeightRecordStandardDO> getBabyHeightRecordStandardPage(BabyHeightRecordStandardPageReqBO pageReqBO);

    List<BabyHeightRecordStandardDO> getBabyHeightRecordStandardByCountryCode(String countryCode,Short sex);
}
