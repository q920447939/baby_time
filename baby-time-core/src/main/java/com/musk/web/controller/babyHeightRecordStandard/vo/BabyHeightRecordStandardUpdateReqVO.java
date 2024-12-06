package com.musk.web.controller.babyHeightRecordStandard.vo;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
public class BabyHeightRecordStandardUpdateReqVO {

    @NotNull(message = "编号不能为空")
    private Integer id;

    private String countryCode;

    private Integer babySex;

    private BigDecimal standardHeight;

    private Integer standardMonth;

    private String standardMonthDescribe;

}
