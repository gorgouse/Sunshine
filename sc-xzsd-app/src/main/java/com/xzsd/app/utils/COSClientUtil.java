package com.xzsd.app.utils;

import com.neusoft.util.StringUtil;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;


public class COSClientUtil {


    private static final String bucketName = "item-1301846529";
    private static final String secretId = "AKID2ub6HDyf03rPfHrfZO8iCRLbo31CiuQY";
    private static final String secretKey = "yg8F6ez3zd0KVP2TdfQtJbbJuGUR6i9J";
    private static final COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
    private static final ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
    private static final COSClient cosClient = new COSClient(cred, clientConfig);


    private COSClient cOSClient;

    public COSClientUtil() {
        cOSClient = new COSClient(cred, clientConfig);
    }


    public void destory() {
        cOSClient.shutdown();
    }


    public void uploadImg2Cos(String url) throws Exception {
        File fileOnServer = new File(url);
        FileInputStream fin;
        try {
            fin = new FileInputStream(fileOnServer);
            String[] split = url.split("/");
            this.uploadFile2Cos(fin, split[split.length - 1]);
        } catch (FileNotFoundException e) {
            throw new Exception("图片上传失败");
        }
    }

    public String uploadFile2Cos(MultipartFile file) throws Exception {
        if (file.getSize() > 10 * 1024 * 1024) {
            throw new Exception("图片过大！");
        }
        //demo.jpg
        String originalFilename = file.getOriginalFilename();
        //.jpg
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        String name = StringUtil.getCommonCode(3) + substring;
        try {
            InputStream inputStream = file.getInputStream();
            this.uploadFile2Cos(inputStream, name);
            return name;
        } catch (Exception e) {
            throw new Exception("图片上传失败");
        }
    }


    public String getImgUrl(String fileUrl) {
        return getUrl(fileUrl);
    }


    public String getUrl(String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 1);
        // 生成URL
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }


    public String uploadFile2Cos(InputStream instream, String fileName) {
        String ret = "";
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getContentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = cOSClient.putObject(bucketName, fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }


    public static String getContentType(String filenameExtension) {
        if (filenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (filenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
                || filenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (filenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (filenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (filenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (filenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }
}
