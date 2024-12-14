package com.musk.web.controller.babyUploadDiscuss.vo;


import lombok.*;

@Data
public class BabyUploadDiscussAddReqVO {

    private Integer babyId;

    private Integer uploadId;

    private Integer discussMemberId;

    private String content;

}