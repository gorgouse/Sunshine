package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    //商品新增
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsAdd(GoodsData goodsData)     //橙色代表这个方法与与Mapper的xuml文件对应
    {
        //检验ID是否存在
        int countGoodsId = goodsDao.countGoodsId(goodsData);             //比较ID不同
        if (0 != countGoodsId)
        {
            return AppResponse.success("新增的商品已存在，请再次尝试");
        }

        goodsData.setGoodsId(StringUtil.getCommonCode(2));  //生成随机编码ID
        goodsData.setIsDelete(0);   //设置作废标记为0
        // 新增商品
        int count = goodsDao.goodsAdd(goodsData);        //紫色字代表数据库的方法ID
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");


    }

          //分页查询

    public AppResponse goodsListCheck(GoodsData goodsData) {
        PageHelper.startPage(goodsData.getPageNum(), goodsData.getPageSize());  //静态方法，传递两个参数（当前页码，每页查询条数）
        List<GoodsData> goodsDataList = goodsDao.goodsListCheck(goodsData);
        // 包装Page对象
        PageInfo<GoodsData> pageData = new PageInfo<GoodsData>(goodsDataList);          //返回的信息就是pageInfo对象，该类是插件里的类，
        return AppResponse.success("查询成功！", pageData);

      }

    /**
     * demo 删除商品
     *
     * @param goodsId
     * @param goodsCode
     * @return
     * @Author sumintao
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsDelete(String goodsId, String goodsCode) {
        List<String> listId = Arrays.asList(goodsId.split(","));  //？
        // 删除商品
        int count = goodsDao.goodsDelete(listId, goodsCode);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }




    /**
     * demo 修改商品
     *
     * @param goodsData
     * @return
     * @Author xumintao
     * @Date 2020-03-21
     */


    @Transactional(rollbackFor = Exception.class)
    public AppResponse goodsUpdate(GoodsData goodsData) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countGoodsId = goodsDao.countGoodsId(goodsData);              //比较ID不同
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





//商品详情信息查询
    public AppResponse getGoodsByGoodsId(String goodsId)
        {

        GoodsData goodsData =  goodsDao.getGoodsByGoodsId(goodsId);
        return AppResponse.success("查询成功！", goodsData);




    }
}
