package com.musk.web.controller.babyHeightRecordStandard.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
public class BabyHeightRecordStandardRespVO {

    private Integer id;

    private String countryCode;

    private Integer babySex;

    private BigDecimal standardHeight;

    private Integer standardMonth;

    private String standardMonthDescribe;

    private String creator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime createTime;

    private String updater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime updateTime;

}
