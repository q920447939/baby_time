package com.musk.web.controller.baby.vo;

import lombok.*;

import java.time.LocalDate;

import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BabyInfoPageReqVO extends PageParam {

    private String name;

    private String avatarUrl;

    private Short sex;


    private LocalDate birthday;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
