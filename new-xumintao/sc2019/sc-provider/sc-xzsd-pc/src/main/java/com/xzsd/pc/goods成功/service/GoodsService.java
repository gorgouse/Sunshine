package com.xzsd.pc.goods成功.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import com.xzsd.pc.goods成功.controller.GoodsController;
import com.xzsd.pc.goods成功.dao.GoodsDao;
import com.xzsd.pc.goods成功.entity.GoodsData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    /**
     * 商品新增
     * @param goodsData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsAdd(GoodsData goodsData)
    {
        int countGoodsId = goodsDao.countGoodsId(goodsData);
        if (0 != countGoodsId)
        {
            return AppResponse.success("新增的商品已存在，请再次尝试");
        }
        goodsData.setGoodsId(StringUtil.getCommonCode(2));
        goodsData.setIsDelete(0);   //设置作废标记为0
        // 新增商品
        int count = goodsDao.goodsAdd(goodsData);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 更新商品状态
     * @param goodsInfo
     * @return
     * @author
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsStatus(GoodsData goodsInfo){





        //分割字符
        List<String> listGoodsId = Arrays.asList(goodsInfo.getGoodsId().split(","));
        List<String> listVersion = Arrays.asList(goodsInfo.getVersion().split(","));

        List<GoodsData> goodsInfoList = new ArrayList<>();
        for (int i = 0; i < listGoodsId.size() && i <listVersion.size(); i++) {
            GoodsData info = new GoodsData();
            //设置商品id
            info.setGoodsId(listGoodsId.get(i));
            //设置版本号
            info.setVersion(listVersion.get(i));
            //设置更新人
            info.setUpdateBy(goodsInfo.getUpdateBy());
            //设置商品状态
            info.setGoodsState(goodsInfo.getGoodsState());
            goodsInfoList.add(info);
        }
        int count = goodsDao.updateGoodsStatus(goodsInfoList);
        if(count == 0){
            return AppResponse.versionError("更新商品状态失败！");
        }
        return AppResponse.success("更新商品状态成功！");



    }
    /**
     * 商品分页查询
     * @param goodsData
     * @return
     */
    public AppResponse goodsListCheck(GoodsData goodsData) {
        PageHelper.startPage(goodsData.getPageNum(), goodsData.getPageSize());  //静态方法，传递两个参数（当前页码，每页查询条数）
        List<GoodsData> goodsDataList = goodsDao.goodsListCheck(goodsData);
        // 包装Page对象
        PageInfo<GoodsData> pageData = new PageInfo<GoodsData>(goodsDataList);          //返回的信息就是pageInfo对象，该类是插件里的类，
        return AppResponse.success("查询成功！", pageData);
      }
    /**
     * 商品删除
     * @param goodsId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsDelete(String goodsId, String userId) {
        List<String> listId = Arrays.asList(goodsId.split(","));  //？
        // 删除商品
        int count = goodsDao.goodsDelete(listId,userId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * 修改商品
     * @param goodsData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsUpdate(GoodsData goodsData) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countGoodsId = goodsDao.countGoodsId(goodsData);
        if (0 != countGoodsId)
        {
            return AppResponse.success("新增的商品已存在，请再次尝试");
        }
        // 修改用户信息
        int count = goodsDao.goodsUpdate(goodsData);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 商品详情
     * @param goodsId
     * @return
     */
    public AppResponse getGoodsByGoodsId(String goodsId)
        {

        GoodsData goodsData =  goodsDao.getGoodsByGoodsId(goodsId);
        return AppResponse.success("商品查询成功！", goodsData);
    }

    /**
     * 上传图片
     */
    public void goodsUpLoadPicture() {

        COSCredentials cred = new BasicCOSCredentials("AKID2ub6HDyf03rPfHrfZO8iCRLbo31CiuQY", "yg8F6ez3zd0KVP2TdfQtJbbJuGUR6i9J");
        //
        ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));

        COSClient cosclient = new COSClient(cred, clientConfig);
       //
        String bucketName = "item-1301846529";

        String key = "3.png";
        File localFile = new File("F:\\idea\\SpringCloud\\picture\\3.png");
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
