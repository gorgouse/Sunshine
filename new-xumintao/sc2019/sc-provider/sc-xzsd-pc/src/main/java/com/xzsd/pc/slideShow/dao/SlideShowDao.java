package com.xzsd.pc.slideShow.dao;


import com.xzsd.pc.slideShow.entity.SlideShowData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideShowDao {

    int countSlideShowId(SlideShowData slideShowData);  //增，改

    int slideShowAdd(SlideShowData slideShowData);  //增



    List<SlideShowData> slideShowListCheck(SlideShowData slideShowData);//列表查询



    int slideShowDelete(@Param("listId") List<String> listId, @Param("userCode") String userCode); //删除


    int slideShowUpdate(SlideShowData slideShowData); //修改








    SlideShowData getSlideShowBySlideShowId(@Param("slideShowId") String slideShowId); //注释


}
