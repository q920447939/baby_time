package com.musk.web.controller.uploadlist.vo;

import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class UploadListSaveReqVO {

    private Integer id;

    @NotNull(message = "宝宝id不能为空")
    private Integer babyId;

    @NotNull(message = "上传类型(1:图片,2:视频)不能为空")
    private Short uploadType;

    @NotNull(message = "上传人ID不能为空")
    private Integer uploadUser;

    @NotNull(message = "上传时间不能为空")
    private LocalDateTime uploadTime;

    private String remark;

}
