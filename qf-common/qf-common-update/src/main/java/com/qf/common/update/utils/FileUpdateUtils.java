package com.qf.common.update.utils;

import cn.hutool.core.util.RandomUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import com.qf.common.update.config.OssConfigProperties;
import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

@Component
public class FileUpdateUtils {

    public static final String IMG_PREFIX_PATH = "images/";
    public static final String IMG_PREFIX_DEFAULT_NAME = "IMG_";
    public static final int RESULT_STATUS_CODE_SUCCESS = 200;
    @Resource
    OSS oss;
    @Resource
    OssConfigProperties ossConfigProperties;




    public  String load(MultipartFile file) {
        try {
            //获取 文件名称
            String objectName = getKey(Objects.requireNonNull(file.getOriginalFilename()));

            // 获取 文件上传对象
            PutObjectRequest request = new PutObjectRequest(ossConfigProperties.getBucketName(), objectName,new ByteArrayInputStream(file.getBytes()));

            request.setProcess("true");
            //文件上传
            PutObjectResult putObjectResult = oss.putObject(request);

            if (putObjectResult.getResponse().getStatusCode() != RESULT_STATUS_CODE_SUCCESS) {
                throw new RuntimeException();
            }
            return getImagUrl(objectName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取上传OSS key
     * 9e586e01d7cb5d135d560c9b2cd32a2e.jpg
     * 获取图片的后缀名
     * //images/20230519/xxx.png
     * IMG_日期_随机(4) + 后缀名
     */

    public static String getKey(String originalFilename) {
        // 文件后缀
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String currentDate = DateUtils.formatDate(new Date(), "yyyyMMddhhmmss");
        String number = RandomUtil.randomNumbers(4);
        String fileName = String.format("%s%s%s%s", IMG_PREFIX_DEFAULT_NAME, currentDate, number, suffixName);

        return String.format("%s%s%s%s", IMG_PREFIX_PATH, DateUtils.formatDate(new Date(), "yyyyMMdd"), "/", fileName);
    }

    public    String getImagUrl(String objectName) {

        Date expiration = new Date(System.currentTimeMillis() + 24 * 360 * 30 * 1000);

        URL url = oss.generatePresignedUrl(ossConfigProperties.getBucketName(), objectName, expiration);
        return url.toString();
    }
}
