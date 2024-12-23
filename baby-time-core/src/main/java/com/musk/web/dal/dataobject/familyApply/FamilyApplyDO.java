package com.musk.web.dal.dataobject.familyApply;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 * 家庭申请表 DO
 *
 * @author 代码生成器
 */
@TableName("family_apply")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilyApplyDO extends BaseDO {

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
     * 申请家庭ID
     */
    @TableField("apply_family_id")
    private Integer applyFamilyId;

    /**
     * 申请家庭编码
     */
    @TableField("apply_family_code")
    private String applyFamilyCode;

    /**
     * 申请人
     */
    @TableField("apply_id")
    private Integer applyId;

    /**
     * 申请状态(1:申请中,2:申请成功,3:拒绝,4:申请人撤销)
     */
    @TableField("apply_status")
    private Integer applyStatus;

    /**
     * 拒绝原因
     */
    @TableField("fail_reason")
    private String failReason;

}