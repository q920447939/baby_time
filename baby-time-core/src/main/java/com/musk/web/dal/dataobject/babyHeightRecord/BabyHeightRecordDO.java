package com.musk.web.dal.dataobject.babyHeightRecord;

import com.baomidou.mybatisplus.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 *  DO
 *
 * @author 代码生成器
 */
@TableName("baby_height_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyHeightRecordDO extends BaseDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private Integer tenantId;

    /**
     * 宝宝id
     */
    @TableField("baby_id")
    private Integer babyId;

    /**
     * 身高
     */
    @TableField("height")
    private BigDecimal height;

    /**
     * 记录版本
     */
    @TableField("version")
    private Integer version;

    /**
     * 记录日期
     */
    @TableField("record_time")
    private LocalDate recordTime;

}