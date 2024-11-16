package com.musk.web.dal.dataobject.info;

import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 * 宝宝信息 DO
 *
 * @author 马斯克源码
 */
@TableName("baby_info")
@KeySequence("baby_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BabyInfoDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;

    /**
     * 家庭ID
     */
    private Integer familyId;


    /**
     * 宝宝昵称
     */
    private String name;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 性别
     */
    private Short sex;
    /**
     * 出生日期
     */
    private LocalDate birthday;

}
