package com.musk.web.controller.babyHeightRecordStandard.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BabyHeightRecordStandardRelationRespVO {

    private Integer id;

    private String countryCode;

    private Integer babySex;

    private BigDecimal standardHeight;

    private Integer standardMonth;

    private String standardMonthDescribe;

    private String creator;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime relationTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime createTime;

    private String updater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime updateTime;

}
