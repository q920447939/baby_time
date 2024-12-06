package com.musk.web.controller.babyHeightRecord.vo;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BabyHeightRecordUpdateReqVO {

    @NotNull(message = "编号不能为空")
    private Integer id;

    private Integer babyId;

    private BigDecimal height;

    private Integer version;

    private LocalDate recordTime;

}
