package com.musk.web.controller.family.vo;

import lombok.*;
import java.util.*;

import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FamilyPageReqVO extends PageParam {

    private String familyName;

    private Integer familyMemberCount;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
