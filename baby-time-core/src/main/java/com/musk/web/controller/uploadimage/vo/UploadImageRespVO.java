package com.musk.web.controller.uploadimage.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import java.util.*;

import org.example.musk.common.util.date.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class UploadImageRespVO {

    private Integer id;

    private Integer babyId;

    private Integer uploadId;

    private String imageUrl;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDateTime createTime;

}
