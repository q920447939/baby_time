package com.musk.web.controller.family.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.musk.web.controller.uploadlist.vo.MemberSimpleMoreResVO;
import com.musk.web.controller.uploadlist.vo.MemberSimpleResVO;
import lombok.Data;
import org.example.musk.common.util.date.DateUtils;

import java.time.LocalDateTime;

@Data
public class FamilyRelationRespVO {


    private Integer roleId;
    private String roleName;

    @JsonFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY, timezone = DateUtils.TIME_ZONE_DEFAULT)
    private LocalDateTime applyTime;


    private MemberSimpleMoreResVO memberSimpleMoreResVO;


}
