package com.musk.web.controller.familyApply.vo;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class FamilyApplyAddReqVO {

    @NotBlank(message = "申请家庭编码不能为空")
    private String applyFamilyCode;

    private String applyReason;

    private Integer applyId;

}
