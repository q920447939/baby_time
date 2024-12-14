package com.musk.web.dal.dataobject.babyUploadDiscuss.bo;

import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BabyUploadDiscussPageReqBO extends PageParam {

    private Integer babyId;

    private Integer uploadId;

    private Integer discussMemberId;

    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime[] createTime;

}