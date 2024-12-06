package com.musk.web.event.familyMember;

import com.musk.web.dal.dataobject.familyMemberRelation.FamilyMemberRelationDO;
import com.musk.web.event.familyMember.entity.FamilyMemberEventInfo;
import com.musk.web.service.familyMemberRelation.FamilyMemberRelationService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: FamilyMemberListener
 *
 * @author
 * @Description:
 * @date 2024年11月19日
 */
@Slf4j
@Component
public class FamilyMemberListener {

    @Resource
    private FamilyMemberRelationService memberRelationService;


    @EventListener
    public void handleEvent(FamilyMemberEventInfo event) {
        log.info("event:{}", event);
        FamilyMemberRelationDO info = new FamilyMemberRelationDO();
        info.setFamilyId(event.getFamilyId());
        info.setMemberId(event.getMemberId());
        //memberRelationService.save(info);
    }
}
