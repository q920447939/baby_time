package com.musk.web.controller.babyHeightRecord.vo;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BabyHeightRecordAddReqVO {

    private Integer babyId;

    private BigDecimal height;

    private Integer version;

    private LocalDate recordTime;

}
