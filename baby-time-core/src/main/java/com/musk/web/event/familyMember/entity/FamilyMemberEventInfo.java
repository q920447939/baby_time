package com.musk.web.event.familyMember.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class FamilyMemberEventInfo {
    private Integer familyId;
    private Integer memberId;
}
