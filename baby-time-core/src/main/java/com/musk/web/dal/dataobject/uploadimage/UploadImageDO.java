package com.musk.web.dal.dataobject.uploadimage;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 * 上传图片 DO
 *
 * @author 马斯克源码
 */
@TableName("baby_upload_image")
@KeySequence("baby_upload_image_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadImageDO extends BaseDO {

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
     * 图片地址
     */
    private String imageUrl;

}
