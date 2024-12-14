package com.musk.web.dal.dataobject.babyUploadTag;

import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 * 上传文件标签表 DO
 *
 * @author 代码生成器
 */
@TableName("baby_upload_tag")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyUploadTagDO extends BaseDO {

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
     * 标签名称
     */
    @TableField("tag_name")
    private String tagName;

}