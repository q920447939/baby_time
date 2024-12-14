package com.musk.web.dal.dataobject.babyUploadDiscuss;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 *  DO
 *
 * @author 代码生成器
 */
@TableName("baby_upload_discuss")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyUploadDiscussDO extends BaseDO {

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
     * 上传ID
     */
    @TableField("upload_id")
    private Integer uploadId;

    /**
     * 评论者id
     */
    @TableField("discuss_member_id")
    private Integer discussMemberId;

    /**
     * 评论
     */
    @TableField("content")
    private String content;

}