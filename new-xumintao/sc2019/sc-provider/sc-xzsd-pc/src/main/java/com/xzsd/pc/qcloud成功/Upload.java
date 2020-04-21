package com.xzsd.pc.qcloud成功;

import java.io.File;
import java.net.URL;
import java.util.Date;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

public class Upload {
    public static void main(String[] args) {

        COSCredentials cred = new BasicCOSCredentials("AKID2ub6HDyf03rPfHrfZO8iCRLbo31CiuQY", "yg8F6ez3zd0KVP2TdfQtJbbJuGUR6i9J");
        //
        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));

        COSClient cosclient = new COSClient(cred, clientConfig);
        //
        String bucketName = "item-1301846529";

        String key = "3.png";
        File localFile = new File("F:\\idea\\SpringCloud\\picture\\2.png");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);

        putObjectRequest.setStorageClass(StorageClass.Standard_IA);


        cosclient.shutdown();

        try {
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);

            Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
            URL url = cosclient.generatePresignedUrl(bucketName, key, expiration);
            System.out.println("图片在COS服务器上的url:" + url);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
            System.out.println("图片上传成功");

        } catch (CosServiceException e)
        {
            System.out.println("图片上传失败");
            e.printStackTrace();
        }
    }

}
