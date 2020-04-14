package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.GoodsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    /**
     * 获取商品ID数量
     * @param goodsData
     * @return
     */
    int countGoodsId(GoodsData goodsData);
    /**
     * 商品新增
     * @param goodsData
     * @return
     */
    int goodsAdd(GoodsData goodsData);
    /**
     * 商品列表查询
     * @param goodsData
     * @return
     */
     List<GoodsData> goodsListCheck(GoodsData goodsData);
    /**
     * 商品删除
     * @param listId
     * @param goodsCode
     * @return
     */
     int goodsDelete(@Param("listId") List<String> listId, @Param("goodsCode") String goodsCode);
    /**
     * 商品信息修改
     * @param goodsData
     * @return
     */
     int goodsUpdate(GoodsData goodsData);

    /**
     * 商品信息详情
     * @param goodsId
     * @return
     */
    GoodsData getGoodsByGoodsId(@Param("goodsId") String goodsId);

}
