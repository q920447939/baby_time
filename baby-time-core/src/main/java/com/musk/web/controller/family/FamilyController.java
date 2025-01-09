package com.musk.web.controller.family;

import cn.hutool.core.collection.CollUtil;
import com.musk.web.FamilyConfig;
import com.musk.web.controller.family.vo.FamilyPageReqVO;
import com.musk.web.controller.family.vo.FamilyRelationRespVO;
import com.musk.web.controller.family.vo.FamilyRespVO;
import com.musk.web.controller.family.vo.FamilySaveReqVO;
import com.musk.web.controller.uploadlist.vo.MemberSimpleMoreResVO;
import com.musk.web.controller.uploadlist.vo.MemberSimpleResVO;
import com.musk.web.dal.dataobject.family.FamilyDO;
import com.musk.web.dal.dataobject.familyMemberRelation.FamilyMemberRelationDO;
import com.musk.web.enums.role.RoleInfoEnums;
import com.musk.web.service.family.FamilyService;
import com.musk.web.service.familyMemberRelation.FamilyMemberRelationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.example.musk.auth.entity.member.MemberDO;
import org.example.musk.auth.service.core.member.MemberService;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.example.musk.common.pojo.CommonResult.success;
import static org.example.musk.common.pojo.CommonResult.successNoData;


@RestController
@RequestMapping("/api/baby/family")
@Validated
public class FamilyController {

    @Resource
    private FamilyService familyService;

    @Resource
    private FamilyMemberRelationService familyMemberRelationService;


    @Resource
    private MemberService memberService;

    /**
     * 创建家庭
     */
    @PostMapping("/create")
    public CommonResult<Integer> createFamily(@Valid @RequestBody FamilySaveReqVO createReqVO) {
        createReqVO.setCreateId(ThreadLocalTenantContext.getMemberId());
        createReqVO.setFamilyBackgroundUrl(createReqVO.getFamilyBackgroundUrl());
        return success(familyService.createFamily(createReqVO));
    }

    /**
     * 更新家庭
     */
    @PutMapping("/update")
    public CommonResult<Boolean> updateFamily(@Valid @RequestBody FamilySaveReqVO updateReqVO) {
        familyService.updateFamily(updateReqVO);
        return success(true);
    }

    /**
     * 删除家庭
     */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteFamily(@RequestParam("id") Integer id) {
        familyService.deleteFamily(id);
        return success(true);
    }

    /**
     * 获得家庭
     */
    @GetMapping("/get")
    public CommonResult<List<FamilyRespVO>> getFamily() {
        Integer memberId = ThreadLocalTenantContext.getMemberId();
        List<FamilyMemberRelationDO> familyMemberRelationList = familyMemberRelationService.getFamilyMemberRelationByMemberId(memberId);
        return CommonResultUtils.wrapEmptyObjResult(familyMemberRelationList,()->{
            if (CollUtil.isEmpty(familyMemberRelationList)) {
                return Collections.emptyList();
            }
            List<Integer> familyIds = familyMemberRelationList.stream().map(k -> k.getFamilyId()).toList();

            Map<Integer, FamilyMemberRelationDO> familyMemberRelationMap = familyMemberRelationList.stream().collect(Collectors.toMap(k -> k.getFamilyId(), Function.identity(), (a, b) -> b));
            List<FamilyDO> familyList = familyService.getFamily(familyIds);
            List<FamilyRespVO> familyRespVOList  = new ArrayList<>();
            for (FamilyDO familyDO : familyList) {
                FamilyRespVO familyRespVO = BeanUtils.toBean(familyDO, FamilyRespVO.class);
                FamilyMemberRelationDO familyMemberRelationDO = familyMemberRelationMap.get(familyDO.getId());
                familyRespVO.setRoleId(familyMemberRelationDO.getRoleId());
                familyRespVO.setRoleName(RoleInfoEnums.getRoleInfoEnumsByRoleId(familyMemberRelationDO.getRoleId()).getDesc());
                familyRespVO.setFamilyBackgroundUrl(familyDO.getFamilyBackgroundUrl());
                familyRespVOList.add(familyRespVO);
            }
            return familyRespVOList;
        });
    }


    /**
     * 获得家庭分页
     */
    @GetMapping("/page")
    public CommonResult<PageResult<FamilyRespVO>> getFamilyPage(@Valid FamilyPageReqVO pageReqVO) {
        PageResult<FamilyDO> pageResult = familyService.getFamilyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, FamilyRespVO.class));
    }

    /**
     * 获得家庭分页
     */
    @GetMapping("/familyManager")
    public CommonResult<List<FamilyRelationRespVO>> familyManager(@RequestParam("familyId") Integer familyId) {
        List<FamilyMemberRelationDO> familyMemberRelationDOList = familyMemberRelationService.getFamilyMemberRelationByFamilyId(familyId);
        return  CommonResultUtils.wrapEmptyObjResult(familyMemberRelationDOList,()->{
            Map<Integer, FamilyMemberRelationDO> familyMemberRelationMap =
                    familyMemberRelationDOList.stream().collect(Collectors.toMap(k -> k.getMemberId(), Function.identity()));
            Map<Integer, MemberDO> memberIdMap =  memberService.getMemberInfoByMemberIdsToMap(new ArrayList<>(familyMemberRelationMap.keySet()));
            List<FamilyRelationRespVO> resultList = new ArrayList<>(familyMemberRelationDOList.size());
            for (FamilyMemberRelationDO familyMemberRelationDO : familyMemberRelationDOList) {
                FamilyRelationRespVO familyRelationRespVO = new FamilyRelationRespVO();
                familyRelationRespVO.setRoleId(familyMemberRelationDO.getRoleId());
                familyRelationRespVO.setRoleName(RoleInfoEnums.getRoleInfoEnumsByRoleId(familyMemberRelationDO.getRoleId()).getDesc());
                familyRelationRespVO.setApplyTime(familyMemberRelationDO.getCreateTime());
                familyRelationRespVO.setMemberSimpleMoreResVO(BeanUtils.toBean(memberIdMap.get(familyMemberRelationDO.getMemberId()), MemberSimpleMoreResVO.class));
                resultList.add(familyRelationRespVO);
            }
            return resultList;
        });
    }

    /**
     * 将用户移除家庭
     */
    @GetMapping("/removeFamilyMember")
    public CommonResult<Boolean> removeFamilyMember(@RequestParam("familyId") Integer familyId,@RequestParam("memberId") Integer memberId) {
        return success(familyMemberRelationService.removeFamilyMember(familyId,memberId));
    }

    /**
     * 设置某个用户角色
     */
    @GetMapping("/setFamilyMemberRole")
    public CommonResult<Boolean> setFamilyMemberRole(@RequestParam("familyId") Integer familyId,@RequestParam("memberId") Integer memberId,@RequestParam("roleId") Integer roleId) {
        return success(familyMemberRelationService.setFamilyMemberRole(familyId,memberId,roleId));
    }

}
