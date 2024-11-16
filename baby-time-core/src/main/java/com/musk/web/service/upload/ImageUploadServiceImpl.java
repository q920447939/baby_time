/**
 * @Project:
 * @Author:
 * @Date: 2024年04月11日
 */
package com.musk.web.service.upload;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service("imageUploadService")
public class ImageUploadServiceImpl implements UploadService {

    @Value("${business.image.uploadImagePath}")
    private String uploadImagePath;


    @Override
    public String save(MultipartFile file, String businessPath) {
        if (null == file) {
            return StrUtil.EMPTY;
        }
        File targetFile = null;
        try {
            //获取源文件
            String filePath = uploadImagePath + File.separator + businessPath;//存储地址，此处也可以在application.yml中配置对象用@Value("${*.**}")注解注入内容
            String filename = file.getOriginalFilename();//获取图片名
            String[] names = filename.split("\\.");//获取后缀格式
            String uploadFileName = UUID.randomUUID().toString() + "." + names[names.length - 1];//生成新图片
            targetFile = new File(filePath, uploadFileName);//目标文件
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            //传图片一步到位
            file.transferTo(targetFile);
            return businessPath +File.separator + uploadFileName;
        } catch (Exception e) {
            e.printStackTrace();
            if (null != targetFile) {
                FileUtil.del(targetFile);
            }
            return StrUtil.EMPTY;
        }
    }

    @Override
    public String getServerFilePath(String basePath, String filePath) {
        return basePath + filePath;
    }
}
