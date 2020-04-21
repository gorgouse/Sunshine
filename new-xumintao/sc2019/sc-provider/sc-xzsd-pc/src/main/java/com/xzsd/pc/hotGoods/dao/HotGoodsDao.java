package com.xzsd.pc.hotGoods.dao;

import com.xzsd.pc.hotGoods.entity.HotGoodsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotGoodsDao {
    /**
     * 获取热门商品ID
     * @param hotGoodsData
     * @return
     */
    int countHotGoodsId(HotGoodsData hotGoodsData);
    /**
     * 热门商品新增
     * @param hotGoodsData
     * @return
     */
    int hotGoodsAdd(HotGoodsData hotGoodsData);
    /**
     * 热门商品列表查询
     * @param hotGoodsData
     * @return
     */
    List<HotGoodsData> hotGoodsListCheck(HotGoodsData hotGoodsData);
    /**
     * 热门商品删除
     * @param listId
     * @param userId
     * @return
     */
    int hotGoodsDelete(@Param("listId") List<String> listId, @Param("userId") String userId);
    /**
     * 热门商品修改
     * @param hotGoodsData
     * @return
     */
    int hotGoodsUpdate(HotGoodsData hotGoodsData);
    /**
     * 热门商品详情
     * @param hotGoodsId
     * @return
     */
    HotGoodsData getHotGoodsByHotGoodsId(@Param("hotGoodsId") String hotGoodsId);

}
