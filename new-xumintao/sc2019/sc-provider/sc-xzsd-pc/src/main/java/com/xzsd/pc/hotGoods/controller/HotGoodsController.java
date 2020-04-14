package com.xzsd.pc.hotGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.hotGoods.entity.HotGoodsData;
import com.xzsd.pc.hotGoods.service.HotGoodsService;
import com.xzsd.pc.store.controller.StoreController;
import com.xzsd.pc.store.entity.StoreData;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * 热门商品新增
     * @param hotGoodsData
     * @return
     */
    @PostMapping("/hotgoodsAdd")
    public AppResponse hotgoodsAdd(HotGoodsData hotGoodsData)
    {
        try
        {
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsData.setCreateBy(userId);   //---
            AppResponse appResponse = hotGoodsService.hotGoodsAdd(hotGoodsData);
            return appResponse;
        }catch (Exception e)
        {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品列表
     * @param hotGoodsData
     * @return
     */
    @RequestMapping(value = "hotGoodsListCheck")
    public AppResponse  hotGoodsListCheck(HotGoodsData hotGoodsData) {
        try {
            return  hotGoodsService.hotGoodsListCheck(hotGoodsData);
        } catch (Exception e) {
            logger.error("查询热门商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品删除
     * @param hotGoodsId
     * @return
     */
    @PostMapping("hotGoodsDelete")
    public AppResponse hotGoodsDelete(String hotGoodsId) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            return hotGoodsService.storeDelete(hotGoodsId,userId);
        } catch (Exception e) {
            logger.error("热门商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品修改
     * @param  hotGoodsData
     * @return
     */
    @PostMapping("hotGoodsUpdate")
    public AppResponse  hotGoodsUpdate(HotGoodsData hotGoodsData) {
        try {
            String  userId = AuthUtils.getCurrentUserId();
            hotGoodsData.setCreateBy(userId);
            return  hotGoodsService.hotGoodsUpdate(hotGoodsData);
        } catch (Exception e) {
            logger.error("修改热门商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品详情
     * @param hotGoodsId
     * @return
     */
    @RequestMapping(value = "getStoreByStoreId")
    public AppResponse getHotGoodsByHotGoodsId(String hotGoodsId) {
        try {
            return  hotGoodsService.getHotGoodsByHotGoodsId(hotGoodsId);
        } catch (Exception e) {
            logger.error("热门商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
