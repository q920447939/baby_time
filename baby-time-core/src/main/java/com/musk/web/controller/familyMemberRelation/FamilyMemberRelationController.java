package com.musk.web.controller.familyMemberRelation;

import com.musk.web.controller.familyMemberRelation.vo.FamilyMemberRelationAddReqVO;
import com.musk.web.controller.familyMemberRelation.vo.FamilyMemberRelationPageReqVO;
import com.musk.web.controller.familyMemberRelation.vo.FamilyMemberRelationRespVO;
import com.musk.web.controller.familyMemberRelation.vo.FamilyMemberRelationUpdateReqVO;
import com.musk.web.dal.dataobject.familyMemberRelation.FamilyMemberRelationDO;
import com.musk.web.dal.dataobject.familyMemberRelation.bo.FamilyMemberRelationPageReqBO;
import com.musk.web.service.familyMemberRelation.FamilyMemberRelationService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static org.example.musk.common.pojo.CommonResult.success;

/**
 *  Controller
 *
 * @author 代码生成器
 */
@RestController
@RequestMapping("/api/familyMemberRelation")
@Validated
@Slf4j
public class FamilyMemberRelationController {

    @Resource
    private FamilyMemberRelationService familyMemberRelationService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody FamilyMemberRelationAddReqVO createReqVO) {
        return success(familyMemberRelationService.createFamilyMemberRelation(BeanUtils.toBean(createReqVO, FamilyMemberRelationDO.class)));
    }
    @PutMapping("/updateById")
    public CommonResult<Boolean> update(@Valid @RequestBody FamilyMemberRelationUpdateReqVO updateReqVO) {
        familyMemberRelationService.updateFamilyMemberRelationById(updateReqVO.getId(), BeanUtils.toBean(updateReqVO, FamilyMemberRelationDO.class));
        return success(true);
    }
    @DeleteMapping("/deleteById")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        familyMemberRelationService.deleteFamilyMemberRelation(id);
        return success(true);
    }
    @GetMapping("/get")
    public CommonResult<FamilyMemberRelationRespVO> get(@RequestParam("id") Integer id) {
        FamilyMemberRelationDO familyMemberRelation = familyMemberRelationService.getFamilyMemberRelation(id);
        return CommonResultUtils.wrapEmptyObjResult(familyMemberRelation, () ->{
            return BeanUtils.toBean(familyMemberRelation, FamilyMemberRelationRespVO.class);
        });
    }
    @GetMapping("/page")
    public CommonResult<PageResult<FamilyMemberRelationRespVO>> page(@Valid FamilyMemberRelationPageReqVO pageReqVO) {
        PageResult<FamilyMemberRelationDO> pageResult = familyMemberRelationService.getFamilyMemberRelationPage(BeanUtils.toBean(pageReqVO, FamilyMemberRelationPageReqBO.class));
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, FamilyMemberRelationRespVO.class));
    }

}
