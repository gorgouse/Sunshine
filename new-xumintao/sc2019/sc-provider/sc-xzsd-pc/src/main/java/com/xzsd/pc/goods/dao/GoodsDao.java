package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.GoodsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {

    int countGoodsId(GoodsData goodsData);  //增，改

    int goodsAdd(GoodsData goodsData);  //增



     List<GoodsData> goodsListCheck(GoodsData goodsData);//列表查询

     int goodsDelete(@Param("listId") List<String> listId, @Param("goodsCode") String goodsCode); //删除


     int goodsUpdate(GoodsData goodsData); //修改




    GoodsData getGoodsByGoodsId(@Param("goodsId") String goodsId); //注释

}
