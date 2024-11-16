package com.musk.web.controller.uploadimage;

import com.musk.web.controller.uploadimage.vo.UploadImagePageReqVO;
import com.musk.web.controller.uploadimage.vo.UploadImageRespVO;
import com.musk.web.controller.uploadimage.vo.UploadImageSaveReqVO;
import com.musk.web.dal.dataobject.uploadimage.UploadImageDO;
import com.musk.web.service.uploadimage.UploadImageService;
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
@RequestMapping("/baby/upload-image")
@Validated
public class UploadImageController {

    @Resource
    private UploadImageService uploadImageService;

    /**
    创建上传图片
    */
    @PostMapping("/create")
    public CommonResult<Integer> createUploadImage(@Valid @RequestBody UploadImageSaveReqVO createReqVO) {
        return success(uploadImageService.createUploadImage(createReqVO));
    }

    /**
    更新上传图片
    */
    @PutMapping("/update")
    public CommonResult<Boolean> updateUploadImage(@Valid @RequestBody UploadImageSaveReqVO updateReqVO) {
        uploadImageService.updateUploadImage(updateReqVO);
        return success(true);
    }

    /**
    删除上传图片
    */
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteUploadImage(@RequestParam("id") Integer id) {
        uploadImageService.deleteUploadImage(id);
        return success(true);
    }

    /**
    获得上传图片
    */
    @GetMapping("/get")
    public CommonResult<UploadImageRespVO> getUploadImage(@RequestParam("id") Integer id) {
        UploadImageDO uploadImage = uploadImageService.getUploadImage(id);
        return success(BeanUtils.toBean(uploadImage, UploadImageRespVO.class));
    }


    /**
    获得上传图片分页
    */
    @GetMapping("/page")
    public CommonResult<PageResult<UploadImageRespVO>> getUploadImagePage(@Valid UploadImagePageReqVO pageReqVO) {
        PageResult<UploadImageDO> pageResult = uploadImageService.getUploadImagePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, UploadImageRespVO.class));
    }


}
