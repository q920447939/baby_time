package com.musk.web.dal.dataobject.familyMemberRelation.bo;

import java.time.LocalDateTime;
import lombok.*;
import org.example.musk.common.pojo.db.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FamilyMemberRelationPageReqBO extends PageParam {

    private Integer familyId;

    private Integer memberId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime[] createTime;

}
