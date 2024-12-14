package com.musk.web.dal.dataobject.uploadlist;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 * 上传记录 DO
 *
 * @author 马斯克源码
 */
@TableName("baby_upload_list")
@KeySequence("baby_upload_list_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadListDO extends BaseDO {

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
     * 上传类型(1:图片,2:视频)
     */
    private Short uploadType;
    /**
     * 上传人ID
     */
    private Integer uploadUser;
    /**
     * 上传时间
     */
    private LocalDateTime uploadTime;
    /**
     * 上传信息
     */
    private String remark;

    /**
     * 是否收藏(0:未收藏,1:已收藏)
     */
    private Boolean  isCollect;


}
