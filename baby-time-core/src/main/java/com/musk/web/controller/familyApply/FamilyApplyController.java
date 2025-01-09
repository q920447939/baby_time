package com.musk.web.controller.familyApply;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.musk.web.controller.familyApply.vo.FamilyApplyAddReqVO;
import com.musk.web.controller.familyApply.vo.FamilyApplyPageReqVO;
import com.musk.web.controller.familyApply.vo.FamilyApplyRespVO;
import com.musk.web.controller.familyApply.vo.FamilyApplyUpdateReqVO;
import com.musk.web.controller.uploadlist.vo.MemberSimpleResVO;
import com.musk.web.dal.dataobject.family.FamilyDO;
import com.musk.web.dal.dataobject.familyApply.FamilyApplyDO;
import com.musk.web.dal.dataobject.familyApply.bo.FamilyApplyPageReqBO;
import com.musk.web.dal.dataobject.familyMemberRelation.FamilyMemberRelationDO;
import com.musk.web.enums.applyStatus.ApplyStatusEnum;
import com.musk.web.enums.role.RoleInfoEnums;
import com.musk.web.service.family.FamilyService;
import com.musk.web.service.familyApply.FamilyApplyService;
import com.musk.web.service.familyMemberRelation.FamilyMemberRelationService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.auth.entity.member.MemberDO;
import org.example.musk.auth.service.core.member.MemberService;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.example.musk.common.exception.BusinessException;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.example.musk.common.pojo.CommonResult.success;

/**
 * 家庭申请 Controller
 *
 * @author 代码生成器
 */
@RestController
@RequestMapping("/api/familyApply")
@Validated
@Slf4j
public class FamilyApplyController {

    @Resource
    private FamilyApplyService familyApplyService;

    @Resource
    private FamilyMemberRelationService memberRelationService;

    @Resource
    private FamilyService familyService;

    @Resource
    private MemberService memberService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody FamilyApplyAddReqVO createReqVO) {
        FamilyApplyDO familyApplyDO = BeanUtils.toBean(createReqVO, FamilyApplyDO.class);
        Integer memberId = ThreadLocalTenantContext.getMemberId();
        familyApplyDO.setApplyId(memberId);
        familyApplyDO.setApplyStatus(ApplyStatusEnum.APPLING.getStatus());
        FamilyDO familyDO = familyService.getFamilyByFamilyCode(createReqVO.getApplyFamilyCode());
        if (null != familyDO) {
            familyApplyDO.setApplyFamilyId(familyDO.getId());
        }
        //检查是否是自己已关联的家庭
        List<FamilyMemberRelationDO> memberRelationList = memberRelationService.getFamilyMemberRelationByMemberId(memberId);
        if (CollUtil.isNotEmpty(memberRelationList)) {
            List<Integer> familyIds = memberRelationList.stream().map(k -> k.getFamilyId()).toList();
            List<FamilyDO> familyList = familyService.getFamily(familyIds);
            if (CollUtil.isNotEmpty(familyList)) {
                FamilyDO existsFamily = familyList.stream().filter(k -> StrUtil.equals(k.getFamilyCode(), createReqVO.getApplyFamilyCode())).findFirst().orElse(null);
                if (null != existsFamily) {
                    throw  new BusinessException("4210105","不能申请本账号已关联的家庭");
                }
            }
        }
        return success(familyApplyService.createFamilyApply(familyApplyDO));
    }
    @PutMapping("/updateById")
    public CommonResult<Boolean> update(@Valid @RequestBody FamilyApplyUpdateReqVO updateReqVO) {
        familyApplyService.updateFamilyApplyById(updateReqVO.getId(), BeanUtils.toBean(updateReqVO, FamilyApplyDO.class));
        return success(true);
    }
    @DeleteMapping("/deleteById")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        familyApplyService.deleteFamilyApply(id);
        return success(true);
    }

    @PutMapping("/updateApplyStatus")
    public CommonResult<Boolean> updateApplyStatus(@Valid @RequestParam("id") Integer id,@RequestParam("applyStatus")  Integer applyStatus) {
        boolean b   = familyApplyService.updateApplyStatus(id,applyStatus);
        if (b) {
            FamilyApplyDO familyApply = familyApplyService.getFamilyApply(id);
            @Valid FamilyMemberRelationDO relationInfo = new FamilyMemberRelationDO();
            relationInfo.setFamilyId(familyApply.getApplyFamilyId());
            relationInfo.setMemberId(familyApply.getApplyId());
            relationInfo.setRoleId(RoleInfoEnums.GENERAL.getId());
            b = memberRelationService.createFamilyMemberRelation(relationInfo) > 0;
            if (!b) {
                return success(false);
            }
            b = familyService.updateFamilyCount(familyApply.getApplyFamilyId(),1);
            return  b ? success(true) : success(false);
        }
        return success(false);
    }

    @GetMapping("/get")
    public CommonResult<FamilyApplyRespVO> get(@RequestParam("id") Integer id) {
        FamilyApplyDO familyApply = familyApplyService.getFamilyApply(id);
        return CommonResultUtils.wrapEmptyObjResult(familyApply, () ->{
            return BeanUtils.toBean(familyApply, FamilyApplyRespVO.class);
        });
    }

    @GetMapping("/page")
    public CommonResult<PageResult<FamilyApplyRespVO>> page(@Valid FamilyApplyPageReqVO pageReqVO) {
        PageResult<FamilyApplyDO> pageResult = familyApplyService.getFamilyApplyPage(BeanUtils.toBean(pageReqVO, FamilyApplyPageReqBO.class));

        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> {
            List<MemberDO> memberDOList = memberService.getMemberInfoByMemberIds(new ArrayList<>(pageResult.getList().stream().map(k -> k.getApplyId()).collect(Collectors.toSet())));
            Map<Integer, MemberDO> memberDOMap = memberDOList.stream().collect(Collectors.toMap(k -> k.getId(), Function.identity(), (a, b) -> b));
            List<FamilyApplyRespVO> familyApplyRespVOList = new ArrayList<>(pageResult.getList().size());
            for (FamilyApplyDO familyApplyDO : pageResult.getList()) {
                FamilyApplyRespVO familyApplyRespVO = BeanUtils.toBean(familyApplyDO, FamilyApplyRespVO.class);
                familyApplyRespVO.setApplyInfo(BeanUtils.toBean(memberDOMap.get(familyApplyDO.getApplyId()), MemberSimpleResVO.class));

                familyApplyRespVOList.add(familyApplyRespVO);
            }
            return new PageResult<>(familyApplyRespVOList,pageResult.getTotal());
        });
    }

}
