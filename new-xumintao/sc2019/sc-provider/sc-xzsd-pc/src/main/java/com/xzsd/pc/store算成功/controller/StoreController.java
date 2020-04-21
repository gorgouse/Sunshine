package com.xzsd.pc.store算成功.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.store算成功.entity.StoreData;
import com.xzsd.pc.store算成功.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * 门店新增
     * @param storeData
     * @return
     */
    @PostMapping("/storeAdd")
    public AppResponse storeAdd(StoreData storeData)
    {
        try
        {
            String userId = AuthUtils.getCurrentUserId();
            storeData.setCreateBy(userId);   //---
            AppResponse appResponse = storeService.storesAdd(storeData);
            return appResponse;
        }catch (Exception e)
        {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店列表
     * @param storeData
     * @return
     */
    @RequestMapping(value = "storeListCheck")
    public AppResponse storeListCheck(StoreData storeData) {
        try {
             String userId= SecurityUtils.getCurrentUserId();
            return  storeService. storeListCheck(storeData);
        } catch (Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店删除
     * @param  storeId
     * @return
     */
    @PostMapping("storeDelete")
    public AppResponse storeDelete(String storeId) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            return  storeService.storeDelete(storeId,userId);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店修改
     * @param  storeData
     * @return
     */
    @PostMapping("storeUpdate")
    public AppResponse storeUpdate(StoreData storeData) {
        try {
            String  userId = AuthUtils.getCurrentUserId();
            storeData.setCreateBy(userId);
            return  storeService. storeUpdate(storeData);
        } catch (Exception e) {
            logger.error("修改门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店详情
     * @param storeId
     * @return
     */
    @RequestMapping(value = "getStoreByStoreId")
    public AppResponse getStoreByStoreId(String storeId) {
        try {
            return  storeService.getStoreByStoreId(storeId);
        } catch (Exception e) {
            logger.error("门店查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
