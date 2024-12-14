package com.musk.web.controller.babyUploadDiscuss.vo;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
public class BabyUploadDiscussRespVO {

    private Integer id;

    private Integer babyId;

    private Integer uploadId;

    private Integer discussMemberId;

    private String content;

    private String creator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime createTime;

    private String updater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime updateTime;

}
