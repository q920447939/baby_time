package com.musk.web.controller.babyUploadListRelationTag.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import lombok.*;

@Data
public class BabyUploadListRelationTagRespVO {

    private Integer id;

    private Integer babyId;

    private Integer uploadListId;

    private Integer babyUploadTagId;

    private String creator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime createTime;

    private String updater;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private LocalDateTime updateTime;

}