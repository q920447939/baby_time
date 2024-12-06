package com.musk.web.dal.dataobject.familyMemberRelation;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 *  DO
 *
 * @author 代码生成器
 */
@TableName("family_member_relation")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMemberRelationDO extends BaseDO {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 家庭ID
     */
    @TableField("family_id")
    private Integer familyId;

    /**
     * 会员ID
     */
    @TableField("member_id")
    private Integer memberId;

}
