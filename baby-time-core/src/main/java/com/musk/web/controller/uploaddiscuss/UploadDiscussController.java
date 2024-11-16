package com.musk.web.controller.uploaddiscuss;

import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussPageReqVO;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussRespVO;
import com.musk.web.controller.uploaddiscuss.vo.UploadDiscussSaveReqVO;
import com.musk.web.dal.dataobject.uploaddiscuss.UploadDiscussDO;
import com.musk.web.service.uploaddiscuss.UploadDiscussService;
import org.example.musk.common.pojo.CommonResult;
import org.example.musk.common.pojo.db.PageResult;
import org.example.musk.common.util.object.BeanUtils;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import static org.example.musk.common.pojo.CommonResult.success;


@RestController
@RequestMapping("/baby/upload-discuss")
@Validated
public class UploadDiscussController {

    @Resource
    private UploadDiscussService uploadDiscussService;

    /**
    创建讨论记录
    */
    @PostMapping("/create")
    public CommonResult<Integer> createUploadDiscuss(@Valid @RequestBody UploadDiscussSaveReqVO createReqVO) {
        return success(uploadDiscussService.createUploadDiscuss(createReqVO));
    }

    /**
    更新讨论记录
    */
    @PutMapping("/update")
    public CommonResult<Boolean> updateUploadDiscuss(@Valid @RequestBody UploadDiscussSaveReqVO updateReqVO) {
        uploadDiscussService.updateUploadDiscuss(updateReqVO);
        return success(true);
    }

    /**
    删除讨论记录
    */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteUploadDiscuss(@RequestParam("id") Integer id) {
        uploadDiscussService.deleteUploadDiscuss(id);
        return success(true);
    }

    /**
    获得讨论记录
    */
    @GetMapping("/get")
    public CommonResult<UploadDiscussRespVO> getUploadDiscuss(@RequestParam("id") Integer id) {
        UploadDiscussDO uploadDiscuss = uploadDiscussService.getUploadDiscuss(id);
        return success(BeanUtils.toBean(uploadDiscuss, UploadDiscussRespVO.class));
    }


    /**
    获得讨论记录分页
    */
    @GetMapping("/page")
    public CommonResult<PageResult<UploadDiscussRespVO>> getUploadDiscussPage(@Valid UploadDiscussPageReqVO pageReqVO) {
        PageResult<UploadDiscussDO> pageResult = uploadDiscussService.getUploadDiscussPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, UploadDiscussRespVO.class));
    }


}
