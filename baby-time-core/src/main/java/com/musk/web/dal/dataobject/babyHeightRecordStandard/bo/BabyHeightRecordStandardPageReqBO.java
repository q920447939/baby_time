package com.musk.web.dal.dataobject.babyHeightRecordStandard.bo;

import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BabyHeightRecordStandardPageReqBO extends PageParam {

    private String countryCode;

    private Integer babySex;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime[] createTime;

}