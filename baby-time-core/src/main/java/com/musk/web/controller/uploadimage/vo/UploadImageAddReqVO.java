package com.musk.web.controller.uploadimage.vo;

import lombok.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Data
public class UploadImageAddReqVO {

    private Integer babyId;

    private Integer uploadId;

    @NotEmpty(message = "图片地址不能为空")
    private List<String> imageUrls;

}
