package com.musk.web.controller.babyHeightRecord.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;

@Data
public class BabyHeightRecordRespVO {

    private Integer id;

    private Integer babyId;

    private BigDecimal height;

    private Integer version;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    private LocalDate recordTime;

    private String creator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime createTime;

    private String updater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime updateTime;

}
