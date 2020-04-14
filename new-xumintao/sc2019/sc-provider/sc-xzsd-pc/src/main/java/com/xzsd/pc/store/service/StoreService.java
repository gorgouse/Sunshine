package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsData;
import com.xzsd.pc.store.controller.StoreController;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    /**
     * 门店新增
     * @param storeData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse storesAdd(StoreData storeData)
    {
        int countStoreId = storeDao.countStoreId(storeData);
        if (0 != countStoreId)
        {
            return AppResponse.success("门店已存在，请再次尝试");
        }

        storeData.setStoreId(StringUtil.getCommonCode(2));
        storeData.setIsDelete(0);

        int count = storeDao.storeAdd(storeData);
        if (0 == count) {
            return AppResponse.success("新增门店失败，请重试！");
        }
        return AppResponse.success("新增门店成功！");
    }

    /**
     * 门店列表查询
     * @param storeData
     * @return
     */
    public AppResponse storeListCheck(StoreData storeData) {
        PageHelper.startPage(storeData.getPageNum(), storeData.getPageSize());
        List<StoreData> storeDataList = storeDao.storeListCheck(storeData);
        PageInfo<StoreData> pageData = new PageInfo<StoreData>(storeDataList);
        return AppResponse.success("门店查询成功！", pageData);

    }
    /**
     * 门店删除
     * @param storeId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse storeDelete(String storeId, String userId) {
        List<String> listId = Arrays.asList(storeId.split(","));  //？
        int count = storeDao.storeDelete(listId,userId);
        if (0 == count) {
            return AppResponse.bizError("门店删除失败，请重试！");
        }
        return AppResponse.success("门店删除成功！");
    }
    /**
     * 门店修改
     * @param storeData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse storeUpdate(StoreData storeData) {
        AppResponse appResponse = AppResponse.success("门店修改成功");
        int countStoreId =storeDao.countStoreId(storeData);
        if (0 != countStoreId)
        {
            return AppResponse.success("门店已存在，请再次尝试");
        }
        // 修改用户信息
        int count = storeDao.storeUpdate(storeData);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 门店详情
     * @param storeId
     * @return
     */
    public AppResponse getStoreByStoreId(String storeId)
    {

        StoreData storeData =  storeDao.getStoreByStoreId(storeId);
        return AppResponse.success("门店查询成功！", storeData);
    }
}
