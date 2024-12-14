package com.musk.web.dal.dataobject.uploadlist.bo;

import lombok.*;
import java.util.*;

import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UploadListPageReqBO extends PageParam {

    private Integer babyId;

    private Short uploadType;

    private Integer uploadUser;

    private Byte  isCollect;



    /**
    上传时间
    */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] uploadTime;

    private String remark;


    /**
    创建时间
    */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
