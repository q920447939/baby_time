package com.musk.web.controller.uploadlist.vo;

import com.musk.web.controller.uploadimage.vo.UploadImageAddReqVO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;
import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Data
public class UploadListAddReqVO {

    @NotNull(message = "宝宝id不能为空")
    private Integer babyId;

    @NotNull(message = "上传类型不能为空")
    private Short uploadType;

    private Integer uploadUser;

    @NotNull(message = "上传时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate uploadTime;

    private String remark;

    private UploadImageAddReqVO uploadImageAddReqVO;


}
