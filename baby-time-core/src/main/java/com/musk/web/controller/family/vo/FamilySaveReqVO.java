package com.musk.web.controller.family.vo;

import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Data
public class FamilySaveReqVO {

    private Integer id;
    private Integer createId;

    @NotEmpty(message = "家庭名称不能为空")
    private String familyName;

}
