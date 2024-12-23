package com.musk.web.dal.dataobject.family;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import org.example.musk.common.pojo.db.BaseDO;

/**
 * 家庭 DO
 *
 * @author 马斯克源码
 */
@TableName("family")
@KeySequence("family_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;

    /**
     * 创建者ID
     */
    private Integer createId;

    /**
     * 家庭名称
     */
    private String familyName;
    /**
     * 家庭人员数量
     */
    private Integer familyMemberCount;

    private String familyBackgroundUrl;

    /**
     * 家庭编码
     */
    private String familyCode;

}
