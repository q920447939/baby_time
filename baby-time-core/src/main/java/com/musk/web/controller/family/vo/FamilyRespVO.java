package com.musk.web.controller.family.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.*;
import java.util.*;

import org.example.musk.common.util.date.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class FamilyRespVO {

    private Integer id;

    private String familyName;

    private Integer familyMemberCount;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDateTime createTime;


    private Integer roleId;
    private String roleName;

    private String familyBackgroundUrl;


}
