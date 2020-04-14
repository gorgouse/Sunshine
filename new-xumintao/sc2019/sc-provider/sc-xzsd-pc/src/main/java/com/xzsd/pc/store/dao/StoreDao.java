package com.xzsd.pc.store.dao;

import com.xzsd.pc.goods.entity.GoodsData;
import com.xzsd.pc.store.entity.StoreData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreDao {
    /**
     * 获取门店ID数量
     * @param storeData
     * @return
     */
    int countStoreId(StoreData storeData);  //增，改
    /**
     * 门店新增
     * @param storeData
     * @return
     */
    int  storeAdd(StoreData  storeData);
    /**
     * 门店列表查询
     * @param storeData
     * @return
     */
    List<StoreData>  storeListCheck(StoreData storeData);
    /**
     * 门店删除
     * @param listId
     * @param userId
     * @return
     */
    int  storeDelete(@Param("listId") List<String> listId, @Param("userId") String userId);
    /**
     * 门店修改
     * @param storeData
     * @return
     */
    int  storeUpdate(StoreData storeData);
    /**
     * 门店详情
     * @param storeId
     * @return
     */
    StoreData getStoreByStoreId(@Param("storeId") String storeId);

}
