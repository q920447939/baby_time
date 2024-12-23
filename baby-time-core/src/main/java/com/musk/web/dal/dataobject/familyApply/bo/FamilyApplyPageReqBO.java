package com.musk.web.dal.dataobject.familyApply.bo;

import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FamilyApplyPageReqBO extends PageParam {

    private Integer applyFamilyId;

    private String applyFamilyCode;

    private Integer applyId;

    private Integer applyStatus;

    private String failReason;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime[] createTime;

}