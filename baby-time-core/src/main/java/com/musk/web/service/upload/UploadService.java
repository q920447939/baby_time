/**
 * @Project:
 * @Author:
 * @Date: 2024年04月11日
 */
package com.musk.web.service.upload;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * 上传服务
 *
 * @author
 * @date 2024/07/08
 */
public interface UploadService {

    /**
     * 保存
     *
     * @param file        文件
     * @param businessPath 业务路径
     * @return {@link List }<{@link String }>
     */
    String save(MultipartFile file, String businessPath) ;

    /**
     * 获得服务器文件路径
     *
     * @param basePath 基础路径
     * @param filePath 文件路径
     * @return {@link String }
     */
    String getServerFilePath(String basePath,String filePath );
}
