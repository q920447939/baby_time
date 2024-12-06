package com.musk.web.controller.familyMemberRelation.vo;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class FamilyMemberRelationUpdateReqVO {

    @NotNull(message = "编号不能为空")
    private Integer id;

    private Integer familyId;

    private Integer memberId;

}
