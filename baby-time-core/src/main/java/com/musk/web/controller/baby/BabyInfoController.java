package com.musk.web.controller.baby;

import com.musk.web.controller.baby.vo.BabyInfoPageReqVO;
import com.musk.web.controller.baby.vo.BabyInfoRespVO;
import com.musk.web.controller.baby.vo.BabyInfoSaveReqVO;
import com.musk.web.controller.family.vo.FamilyRespVO;
import com.musk.web.dal.dataobject.family.FamilyDO;
import com.musk.web.dal.dataobject.info.BabyInfoDO;
import com.musk.web.service.family.FamilyService;
import com.musk.web.service.info.BabyInfoService;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.*;

import java.util.function.Supplier;

import static org.example.musk.common.pojo.CommonResult.success;
import static org.example.musk.common.pojo.CommonResult.successNoData;


@RestController
@RequestMapping("/api/baby/info")
@Validated
public class BabyInfoController {

    @Resource
    private BabyInfoService infoService;
    @Resource
    private FamilyService familyService;

    /**
    创建宝宝信息
    */
    @PostMapping("/create")
    public CommonResult<Integer> createInfo(@Valid @RequestBody BabyInfoSaveReqVO createReqVO) {
        return success(infoService.createInfo(createReqVO));
    }

    /**
    更新宝宝信息
    */
    @PutMapping("/update")
    public CommonResult<Boolean> updateInfo(@Valid @RequestBody BabyInfoSaveReqVO updateReqVO) {
        infoService.updateInfo(updateReqVO);
        return success(true);
    }

    /**
    删除宝宝信息
    */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteInfo(@RequestParam("id") Integer id) {
        infoService.deleteInfo(id);
        return success(true);
    }

    /**
    获得宝宝信息
    */
    @GetMapping("/get")
    public CommonResult<BabyInfoRespVO> getInfo(@RequestParam("id") Integer id) {
        BabyInfoDO info = infoService.getInfo(id);
        return CommonResultUtils.wrapEmptyObjResult(info, () ->{
            FamilyDO familyDO = familyService.getFamily(info.getFamilyId());
            BabyInfoRespVO vo = BeanUtils.toBean(info, BabyInfoRespVO.class);
            vo.setFamilyRespVO( BeanUtils.toBean(familyDO, FamilyRespVO.class));
            return vo;
        });
    }


    /**
    获得宝宝信息分页
    */
    @GetMapping("/page")
    public CommonResult<PageResult<BabyInfoRespVO>> getInfoPage(@Valid BabyInfoPageReqVO pageReqVO) {
        PageResult<BabyInfoDO> pageResult = infoService.getInfoPage(pageReqVO);
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, BabyInfoRespVO.class));
    }

}
