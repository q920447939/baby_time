package com.musk.web.controller.babyUploadListRelationTag.vo;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class BabyUploadListRelationTagUpdateReqVO {

    @NotNull(message = "编号不能为空")
    private Integer id;

    private Integer babyId;

    private Integer uploadListId;

    private Integer babyUploadTagId;

}