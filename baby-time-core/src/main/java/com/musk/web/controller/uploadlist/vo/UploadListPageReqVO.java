package com.musk.web.controller.uploadlist.vo;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.*;

import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UploadListPageReqVO extends PageParam {

    @NotNull
    private Integer babyId;

    private Short uploadType;

    private Integer uploadUser;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] uploadTime;


    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
