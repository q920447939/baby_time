package com.musk.web.controller.familyMemberRelation.vo;

import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import static org.example.musk.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FamilyMemberRelationPageReqVO extends PageParam {

    private Integer familyId;

    private Integer memberId;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
