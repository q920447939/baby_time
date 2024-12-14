package com.musk.web.controller.babyUploadTag;

import com.musk.web.controller.babyUploadTag.vo.BabyUploadTagAddReqVO;
import com.musk.web.controller.babyUploadTag.vo.BabyUploadTagPageReqVO;
import com.musk.web.controller.babyUploadTag.vo.BabyUploadTagRespVO;
import com.musk.web.controller.babyUploadTag.vo.BabyUploadTagUpdateReqVO;
import com.musk.web.dal.dataobject.babyUploadTag.BabyUploadTagDO;
import com.musk.web.dal.dataobject.babyUploadTag.bo.BabyUploadTagPageReqBO;
import com.musk.web.service.babyUploadTag.BabyUploadTagService;
import jakarta.annotation.Resource;
import jakarta.validation.*;
import lombok.extern.slf4j.Slf4j;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.commonResult.CommonResultUtils;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.musk.common.pojo.CommonResult.success;

/**
 * 上传文件标签 Controller
 *
 * @author 代码生成器
 */
@RestController
@RequestMapping("/api/babyUploadTag")
@Validated
@Slf4j
public class BabyUploadTagController {

    @Resource
    private BabyUploadTagService babyUploadTagService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody BabyUploadTagAddReqVO createReqVO) {
        return success(babyUploadTagService.createBabyUploadTag(BeanUtils.toBean(createReqVO, BabyUploadTagDO.class)));
    }
    @PutMapping("/updateById")
    public CommonResult<Boolean> update(@Valid @RequestBody BabyUploadTagUpdateReqVO updateReqVO) {
        babyUploadTagService.updateBabyUploadTagById(updateReqVO.getId(), BeanUtils.toBean(updateReqVO, BabyUploadTagDO.class));
        return success(true);
    }
    @DeleteMapping("/deleteById")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        babyUploadTagService.deleteBabyUploadTag(id);
        return success(true);
    }
    @GetMapping("/get")
    public CommonResult<BabyUploadTagRespVO> get(@RequestParam("id") Integer id) {
        BabyUploadTagDO babyUploadTag = babyUploadTagService.getBabyUploadTag(id);
        return CommonResultUtils.wrapEmptyObjResult(babyUploadTag, () ->{
            return BeanUtils.toBean(babyUploadTag, BabyUploadTagRespVO.class);
        });
    }

    @GetMapping("/getBabyUploadTagAll")
    public CommonResult<List<BabyUploadTagRespVO>> getBabyUploadTagAll(@RequestParam("babyId") Integer babyId) {
        List<BabyUploadTagDO> babyUploadTagList = babyUploadTagService.getBabyUploadTagAll(babyId);
        return CommonResultUtils.wrapEmptyObjResult(babyUploadTagList, () ->{
            return BeanUtils.toBean(babyUploadTagList, BabyUploadTagRespVO.class);
        });
    }
    @GetMapping("/page")
    public CommonResult<PageResult<BabyUploadTagRespVO>> page(@Valid BabyUploadTagPageReqVO pageReqVO) {
        PageResult<BabyUploadTagDO> pageResult = babyUploadTagService.getBabyUploadTagPage(BeanUtils.toBean(pageReqVO, BabyUploadTagPageReqBO.class));
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, BabyUploadTagRespVO.class));
    }

}
