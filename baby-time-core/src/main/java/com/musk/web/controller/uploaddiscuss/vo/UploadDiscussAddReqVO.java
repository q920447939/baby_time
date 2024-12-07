package com.musk.web.controller.uploaddiscuss.vo;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
public class UploadDiscussAddReqVO {

    private Integer babyId;

    private Integer uploadId;

    @NotEmpty(message = "评论不能为空")
    private String content;

}
