package com.musk.web.controller.familyApply.vo;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class FamilyApplyUpdateReqVO {

    @NotNull(message = "编号不能为空")
    private Integer id;

    private Integer applyFamilyId;

    private String applyFamilyCode;

    private Integer applyId;

    private Integer applyStatus;

    private String failReason;

}