package com.musk.web.controller.uploaddiscuss.vo;

import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Data
public class UploadDiscussSaveReqVO {

    private Integer id;

    @NotNull(message = "宝宝id不能为空")
    private Integer babyId;

    @NotNull(message = "上传ID不能为空")
    private Integer uploadId;

    @NotEmpty(message = "评论不能为空")
    private String content;

}
