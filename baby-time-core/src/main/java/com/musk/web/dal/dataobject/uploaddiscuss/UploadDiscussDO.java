package com.musk.web.dal.dataobject.uploaddiscuss;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 * 讨论记录 DO
 *
 * @author 马斯克源码
 */
@TableName("baby_upload_discuss")
@KeySequence("baby_upload_discuss_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadDiscussDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * 宝宝id
     */
    private Integer babyId;
    /**
     * 上传ID
     */
    private Integer uploadId;
    /**
     * 上传ID
     */
    private Integer discussMemberId;
    /**
     * 评论
     */
    private String content;

}
