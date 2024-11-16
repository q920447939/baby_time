package com.musk.web.controller.baby.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.musk.web.controller.family.vo.FamilyRespVO;
import lombok.*;
import org.example.musk.common.util.date.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BabyInfoRespVO {

    private Integer id;

    private String name;

    private String avatarUrl;

    private Short sex;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDate birthday;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDateTime createTime;

    private FamilyRespVO familyRespVO;

}
