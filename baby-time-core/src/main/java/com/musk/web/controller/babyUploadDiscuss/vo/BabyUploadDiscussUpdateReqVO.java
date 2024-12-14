package com.musk.web.controller.babyUploadDiscuss.vo;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class BabyUploadDiscussUpdateReqVO {

    @NotNull(message = "编号不能为空")
    private Integer id;

    private Integer babyId;

    private Integer uploadId;

    private Integer discussMemberId;

    private String content;

}