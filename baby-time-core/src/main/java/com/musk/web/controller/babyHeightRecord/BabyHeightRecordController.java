package com.musk.web.controller.babyHeightRecord;

import com.musk.web.controller.babyHeightRecord.vo.BabyHeightRecordAddReqVO;
import com.musk.web.controller.babyHeightRecord.vo.BabyHeightRecordPageReqVO;
import com.musk.web.controller.babyHeightRecord.vo.BabyHeightRecordRespVO;
import com.musk.web.dal.dataobject.babyHeightRecord.BabyHeightRecordDO;
import com.musk.web.dal.dataobject.babyHeightRecord.bo.BabyHeightRecordPageReqBO;
import com.musk.web.service.babyHeightRecord.BabyHeightRecordService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.musk.common.pojo.CommonResult.success;

/**
 * Controller
 *
 * @author 代码生成器
 */
@RestController
@RequestMapping("/api/babyHeightRecord")
@Validated
@Slf4j
public class BabyHeightRecordController {

    @Resource
    private BabyHeightRecordService babyHeightRecordService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody BabyHeightRecordAddReqVO createReqVO) {
        return success(babyHeightRecordService.createBabyHeightRecord(BeanUtils.toBean(createReqVO, BabyHeightRecordDO.class)));
    }

    @DeleteMapping("/deleteById")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        babyHeightRecordService.deleteBabyHeightRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    public CommonResult<BabyHeightRecordRespVO> get(@RequestParam("id") Integer id) {
        BabyHeightRecordDO babyHeightRecord = babyHeightRecordService.getBabyHeightRecord(id);
        return CommonResultUtils.wrapEmptyObjResult(babyHeightRecord, () -> {
            return BeanUtils.toBean(babyHeightRecord, BabyHeightRecordRespVO.class);
        });
    }

    @GetMapping("/getAllRecord")
    public CommonResult<List<BabyHeightRecordRespVO>> getAllRecord(@RequestParam("babyId") Integer babyId) {
        List<BabyHeightRecordDO> babyHeightAllRecord = babyHeightRecordService.getBabyHeightAllRecord(babyId);
        return CommonResultUtils.wrapEmptyObjResult(babyHeightAllRecord, () -> {
            return BeanUtils.toBean(babyHeightAllRecord, BabyHeightRecordRespVO.class);
        });
    }

    @GetMapping("/page")
    public CommonResult<PageResult<BabyHeightRecordRespVO>> page(@Valid BabyHeightRecordPageReqVO pageReqVO) {
        PageResult<BabyHeightRecordDO> pageResult = babyHeightRecordService.getBabyHeightRecordPage(BeanUtils.toBean(pageReqVO, BabyHeightRecordPageReqBO.class));
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, BabyHeightRecordRespVO.class));
    }

}
