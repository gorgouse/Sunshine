package com.xzsd.pc.menu成功.dao;


import com.xzsd.pc.menu成功.entity.MenuData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {

    /**
     * 根据角色查询首页菜单显示的功能
     * @param role
     * @return
     */

    List<MenuData> getPageHomeMenu(@Param("role") String role);
    /**
     * 统计是否存在相同的菜单路由
     * @param menuData
     * @return
     */

    int countMenuUrl(MenuData menuData);

    /**
     * 统计是否存在相同的菜单名
     * @param menuData
     * @return
     */
    int countMenuName(MenuData menuData);


    /**
     * 菜单新增
     * @param menuData
     * @return
     */
    int menuAdd(MenuData menuData);

    /**
     * 所以菜单列表查询
     * @param
     * @return
     */
    List<MenuData> menuListCheck();
    /**
     * 菜单删除
     * @param
     * @param currentUserId
     * @return
     */
    int menuDelete(@Param("menuId")String menuId, @Param("currentUserId") String currentUserId);
    /**
     * 菜单修改
     * @param menuData
     * @return
     */
    int menuUpdate(MenuData menuData);
    /**
     * 菜单详情
     * @param menuId
     * @return
     */
    MenuData getMenuByMenuId(@Param("menuId") String menuId);

}
