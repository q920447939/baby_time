package com.musk.web.controller.uploaddiscuss.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.musk.web.controller.uploadlist.vo.MemberSimpleResVO;
import lombok.*;
import java.util.*;
import java.util.*;

import org.example.musk.common.util.date.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class UploadDiscussRespVO {

    private Integer id;

    private Integer babyId;

    /**
     * 上传ID
     */
    private Integer discussMemberId;

    private Integer uploadId;

    private String content;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDateTime createTime;

    private MemberSimpleResVO memberSimpleResVO;

}
