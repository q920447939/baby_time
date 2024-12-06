package com.musk.web.controller.babyHeightRecordStandard;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.musk.web.controller.babyHeightRecordStandard.vo.BabyHeightRecordStandardAddReqVO;
import com.musk.web.controller.babyHeightRecordStandard.vo.BabyHeightRecordStandardPageReqVO;
import com.musk.web.controller.babyHeightRecordStandard.vo.BabyHeightRecordStandardRelationRespVO;
import com.musk.web.controller.babyHeightRecordStandard.vo.BabyHeightRecordStandardRespVO;
import com.musk.web.controller.babyHeightRecordStandard.vo.BabyHeightRecordStandardUpdateReqVO;
import com.musk.web.dal.dataobject.babyHeightRecordStandard.BabyHeightRecordStandardDO;
import com.musk.web.dal.dataobject.babyHeightRecordStandard.bo.BabyHeightRecordStandardPageReqBO;
import com.musk.web.dal.dataobject.info.BabyInfoDO;
import com.musk.web.service.babyHeightRecordStandard.BabyHeightRecordStandardService;
import com.musk.web.service.info.BabyInfoService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.example.musk.common.pojo.CommonResult.success;
import static org.example.musk.common.pojo.CommonResult.successNoData;

/**
 *  Controller
 *
 * @author 代码生成器
 */
@RestController
@RequestMapping("/api/babyHeightRecordStandard")
@Validated
@Slf4j
public class BabyHeightRecordStandardController {

    @Resource
    private BabyHeightRecordStandardService babyHeightRecordStandardService;

    @Resource
    private BabyInfoService babyInfoService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody BabyHeightRecordStandardAddReqVO createReqVO) {
        return success(babyHeightRecordStandardService.createBabyHeightRecordStandard(BeanUtils.toBean(createReqVO, BabyHeightRecordStandardDO.class)));
    }
    @PutMapping("/updateById")
    public CommonResult<Boolean> update(@Valid @RequestBody BabyHeightRecordStandardUpdateReqVO updateReqVO) {
        babyHeightRecordStandardService.updateBabyHeightRecordStandardById(updateReqVO.getId(), BeanUtils.toBean(updateReqVO, BabyHeightRecordStandardDO.class));
        return success(true);
    }
    @DeleteMapping("/deleteById")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        babyHeightRecordStandardService.deleteBabyHeightRecordStandard(id);
        return success(true);
    }
    @GetMapping("/get")
    public CommonResult<BabyHeightRecordStandardRespVO> get(@RequestParam("id") Integer id) {
        BabyHeightRecordStandardDO babyHeightRecordStandard = babyHeightRecordStandardService.getBabyHeightRecordStandard(id);
        return CommonResultUtils.wrapEmptyObjResult(babyHeightRecordStandard, () ->{
            return BeanUtils.toBean(babyHeightRecordStandard, BabyHeightRecordStandardRespVO.class);
        });
    }

    @GetMapping("/getBabyHeightRecordStandardCountryCode")
    public CommonResult<List<BabyHeightRecordStandardRelationRespVO>> getBabyHeightRecordStandardByCountryCode(@RequestParam("babyId") Integer babyId, @RequestParam("countryCode") String countryCode) {
        BabyInfoDO babyInfoDO = babyInfoService.getInfo(babyId);
        if (null == babyInfoDO) {
            return successNoData();
        }
        List<BabyHeightRecordStandardDO> list = babyHeightRecordStandardService.getBabyHeightRecordStandardByCountryCode(countryCode,babyInfoDO.getSex());
        return CommonResultUtils.wrapEmptyObjResult(list, () ->{
            LocalDate birthday = babyInfoDO.getBirthday();
            LocalDateTime birthdayLocalDateTime = LocalDateTimeUtil.of(birthday);
            List<BabyHeightRecordStandardRelationRespVO> resultList = new ArrayList<>(list.size());
            for (BabyHeightRecordStandardDO babyHeightRecordStandardDO : list) {
                Integer standardMonth = babyHeightRecordStandardDO.getStandardMonth();
                BabyHeightRecordStandardRelationRespVO res = BeanUtils.toBean(babyHeightRecordStandardDO, BabyHeightRecordStandardRelationRespVO.class);
                res.setRelationTime(LocalDateTimeUtil.offset(birthdayLocalDateTime, standardMonth, ChronoUnit.MONTHS));
                resultList.add(res);
            }
            return resultList.stream().filter(k->LocalDateTimeUtil.between(birthdayLocalDateTime,k.getRelationTime(),ChronoUnit.MONTHS) < 2).toList();
        });
    }

    @GetMapping("/page")
    public CommonResult<PageResult<BabyHeightRecordStandardRespVO>> page(@Valid BabyHeightRecordStandardPageReqVO pageReqVO) {
        PageResult<BabyHeightRecordStandardDO> pageResult = babyHeightRecordStandardService.getBabyHeightRecordStandardPage(BeanUtils.toBean(pageReqVO, BabyHeightRecordStandardPageReqBO.class));
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, BabyHeightRecordStandardRespVO.class));
    }

}
