package com.xzsd.pc.menu.dao;


import com.xzsd.pc.menu.entity.MenuData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {

    int menuAdd(MenuData menuData);  //增


    List<MenuData> menuListCheck(MenuData menuData);//列表查询

    int menuDelete(@Param("listId") List<String> listId, @Param("useId") String useId); //删除


    int menuUpdate(MenuData menuData); //修改

    MenuData getMenuByMenuId(@Param("menuId") String menuId); //注释
}
