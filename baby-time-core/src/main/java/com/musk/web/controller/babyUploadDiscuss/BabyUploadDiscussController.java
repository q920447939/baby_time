package com.musk.web.controller.babyUploadDiscuss;

import com.musk.web.controller.babyUploadDiscuss.vo.BabyUploadDiscussAddReqVO;
import com.musk.web.controller.babyUploadDiscuss.vo.BabyUploadDiscussPageReqVO;
import com.musk.web.controller.babyUploadDiscuss.vo.BabyUploadDiscussRespVO;
import com.musk.web.controller.babyUploadDiscuss.vo.BabyUploadDiscussUpdateReqVO;
import com.musk.web.dal.dataobject.babyUploadDiscuss.BabyUploadDiscussDO;
import com.musk.web.dal.dataobject.babyUploadDiscuss.bo.BabyUploadDiscussPageReqBO;
import com.musk.web.service.babyUploadDiscuss.BabyUploadDiscussService;
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
@RequestMapping("/api/babyUploadDiscuss")
@Validated
@Slf4j
public class BabyUploadDiscussController {

    @Resource
    private BabyUploadDiscussService babyUploadDiscussService;

    @PostMapping("/create")
    public CommonResult<Integer> create(@Valid @RequestBody BabyUploadDiscussAddReqVO createReqVO) {
        return success(babyUploadDiscussService.createBabyUploadDiscuss(BeanUtils.toBean(createReqVO, BabyUploadDiscussDO.class)));
    }
    @PutMapping("/updateById")
    public CommonResult<Boolean> update(@Valid @RequestBody BabyUploadDiscussUpdateReqVO updateReqVO) {
        babyUploadDiscussService.updateBabyUploadDiscussById(updateReqVO.getId(), BeanUtils.toBean(updateReqVO, BabyUploadDiscussDO.class));
        return success(true);
    }
    @DeleteMapping("/deleteById")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        babyUploadDiscussService.deleteBabyUploadDiscuss(id);
        return success(true);
    }
    @GetMapping("/get")
    public CommonResult<BabyUploadDiscussRespVO> get(@RequestParam("id") Integer id) {
        BabyUploadDiscussDO babyUploadDiscuss = babyUploadDiscussService.getBabyUploadDiscuss(id);
        return CommonResultUtils.wrapEmptyObjResult(babyUploadDiscuss, () ->{
            return BeanUtils.toBean(babyUploadDiscuss, BabyUploadDiscussRespVO.class);
        });
    }
    @GetMapping("/page")
    public CommonResult<PageResult<BabyUploadDiscussRespVO>> page(@Valid BabyUploadDiscussPageReqVO pageReqVO) {
        PageResult<BabyUploadDiscussDO> pageResult = babyUploadDiscussService.getBabyUploadDiscussPage(BeanUtils.toBean(pageReqVO, BabyUploadDiscussPageReqBO.class));
        return CommonResultUtils.wrapEmptyPageResult(pageResult, () -> BeanUtils.toBean(pageResult, BabyUploadDiscussRespVO.class));
    }

}
