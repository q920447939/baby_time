package com.musk.web.controller.babyUploadTag.vo;


import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BabyUploadTagPageReqVO extends PageParam {

    private Integer babyId;

    private String tagName;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}