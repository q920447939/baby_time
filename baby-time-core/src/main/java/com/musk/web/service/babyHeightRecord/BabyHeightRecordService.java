package com.musk.web.service.babyHeightRecord;

import com.baomidou.mybatisplus.extension.service.IService;
import com.musk.web.dal.dataobject.babyHeightRecord.BabyHeightRecordDO;
import com.musk.web.dal.dataobject.babyHeightRecord.bo.BabyHeightRecordPageReqBO;
import jakarta.validation.*;
import org.example.musk.common.pojo.db.PageResult;

import java.util.List;

/**
 *  Service 接口
 *
 * @author 代码生成器
 */
public interface BabyHeightRecordService extends IService<BabyHeightRecordDO> {

    /**
     * 创建
     *
     * @param babyHeightRecordDO 创建信息
     * @return ID
     */
    Integer createBabyHeightRecord(@Valid BabyHeightRecordDO babyHeightRecordDO);
    /**
     * 更新
     *
     * @param updateBabyHeightRecord 更新信息
     */
    void updateBabyHeightRecordById(Integer id, @Valid BabyHeightRecordDO updateBabyHeightRecord);
    /**
     * 删除
     *
     * @param id 编号
     */
    void deleteBabyHeightRecord(Integer id);
    /**
     * 获得
     *
     * @param id 编号
     * @return
     */
    BabyHeightRecordDO getBabyHeightRecord(Integer id);
    /**
     * 获得分
     *
     * @param pageReqBO 分页查询
     * @return 分页
     */
    PageResult<BabyHeightRecordDO> getBabyHeightRecordPage(BabyHeightRecordPageReqBO pageReqBO);

    List<BabyHeightRecordDO> getBabyHeightAllRecord(Integer babyId);


    BabyHeightRecordDO getBabyHeightLatest(Integer babyId);


}
