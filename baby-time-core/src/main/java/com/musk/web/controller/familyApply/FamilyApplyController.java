package com.musk.web.controller.familyApply;

import com.musk.web.controller.familyApply.vo.FamilyApplyAddReqVO;
import com.musk.web.controller.familyApply.vo.FamilyApplyPageReqVO;
import com.musk.web.controller.familyApply.vo.FamilyApplyRespVO;
import com.musk.web.controller.familyApply.vo.FamilyApplyUpdateReqVO;
import com.musk.web.dal.dataobject.family.FamilyDO;
import com.musk.web.dal.dataobject.familyApply.FamilyApplyDO;
import com.musk.web.dal.dataobject.familyApply.bo.FamilyApplyPageReqBO;
import com.musk.web.enums.applyStatus.ApplyStatusEnum;
import com.musk.web.service.family.FamilyService;
import com.musk.web.service.familyApply.FamilyApplyService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.context.ThreadLocalTenantContext;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
    private FamilyService familyService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody FamilyApplyAddReqVO createReqVO) {
        FamilyApplyDO familyApplyDO = BeanUtils.toBean(createReqVO, FamilyApplyDO.class);
        familyApplyDO.setApplyId(ThreadLocalTenantContext.getMemberId());
        familyApplyDO.setApplyStatus(ApplyStatusEnum.APPLING.getStatus());
        FamilyDO familyDO = familyService.getFamilyByFamilyCode(createReqVO.getApplyFamilyCode());
        if (null != familyDO) {
            familyApplyDO.setApplyFamilyId(familyDO.getId());
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
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, FamilyApplyRespVO.class));
    }

}
