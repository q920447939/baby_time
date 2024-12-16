package com.musk.web.dal.dataobject.babyUploadListRelationTag.bo;

import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BabyUploadListRelationTagPageReqBO extends PageParam {

    private Integer babyId;

    private Integer uploadListId;

    private Integer babyUploadTagId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime[] createTime;

}