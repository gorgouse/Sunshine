package com.xzsd.pc.menu.dao;


import com.xzsd.pc.menu.entity.MenuData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    /**
     * 菜单新增
     * @param menuData
     * @return
     */
    int menuAdd(MenuData menuData);
    /**
     * 菜单列表查询
     * @param menuData
     * @return
     */
    List<MenuData> menuListCheck(MenuData menuData);//列表查询
    /**
     * 菜单删除
     * @param listId
     * @param useId
     * @return
     */
    int menuDelete(@Param("listId") List<String> listId, @Param("useId") String useId); //删除
    /**
     * 菜单修改
     * @param menuData
     * @return
     */
    int menuUpdate(MenuData menuData); //修改
    /**
     * 菜单详情
     * @param menuId
     * @return
     */
    MenuData getMenuByMenuId(@Param("menuId") String menuId); //注释
}
