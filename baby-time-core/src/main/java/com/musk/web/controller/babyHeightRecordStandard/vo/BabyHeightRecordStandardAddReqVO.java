package com.musk.web.controller.babyHeightRecordStandard.vo;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
public class BabyHeightRecordStandardAddReqVO {

    private String countryCode;

    private Integer babySex;

    private BigDecimal standardHeight;

    private Integer standardMonth;

    private String standardMonthDescribe;

}
