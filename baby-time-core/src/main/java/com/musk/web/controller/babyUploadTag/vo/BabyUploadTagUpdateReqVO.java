package com.musk.web.controller.babyUploadTag.vo;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class BabyUploadTagUpdateReqVO {

    @NotNull(message = "编号不能为空")
    private Integer id;

    private Integer babyId;

    private String tagName;

}