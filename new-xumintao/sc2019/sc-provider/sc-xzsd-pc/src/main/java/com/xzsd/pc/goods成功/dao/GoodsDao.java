package com.xzsd.pc.goods成功.dao;


import com.xzsd.pc.goods成功.entity.GoodsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {

    /**
     * 修改商品状态
     * @param goodsInfoList
     * @return
     */
    int updateGoodsStatus(@Param("goodsInfoList") List<GoodsData> goodsInfoList);
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
