package com.musk.web.dal.dataobject.babyHeightRecordStandard;

import com.baomidou.mybatisplus.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 *  DO
 *
 * @author 代码生成器
 */
@TableName("baby_height_record_standard")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyHeightRecordStandardDO extends BaseDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 国家编码
     */
    @TableField("country_code")
    private String countryCode;

    /**
     * 宝宝性别(0:女,1:男)
     */
    @TableField("baby_sex")
    private Integer babySex;

    /**
     * 标准身高
     */
    @TableField("standard_height")
    private BigDecimal standardHeight;

    /**
     * 标准月份
     */
    @TableField("standard_month")
    private Integer standardMonth;

    /**
     * 标准月份描述
     */
    @TableField("standard_month_describe")
    private String standardMonthDescribe;

}