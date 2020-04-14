package com.xzsd.pc.slideShow.dao;


import com.xzsd.pc.slideShow.entity.SlideShowData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideShowDao {
    /**
     * 轮播图ID数量
     * @param slideShowData
     * @return
     */
    int countSlideShowId(SlideShowData slideShowData);
    /**
     * 轮播图新增
     * @param slideShowData
     * @return
     */
    int slideShowAdd(SlideShowData slideShowData);
    /**
     * 轮播图列表查询
     * @param slideShowData
     * @return
     */
    List<SlideShowData> slideShowListCheck(SlideShowData slideShowData);
    /**
     * 轮播图删除
     * @param listId
     * @param userCode
     * @return
     */
    int slideShowDelete(@Param("listId") List<String> listId, @Param("userCode") String userCode);
    /**
     * 轮播图修改
     * @param slideShowData
     * @return
     */
    int slideShowUpdate(SlideShowData slideShowData);
    /**
     * 轮播图详情
     * @param slideShowId
     * @return
     */
    SlideShowData getSlideShowBySlideShowId(@Param("slideShowId") String slideShowId);


}
