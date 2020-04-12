package com.xzsd.pc.menu.comtroller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.menu.entity.MenuData;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private MenuService menuService ;
    /**
     * 菜单新增
     * @param menuData
     * @return
     */
    @PostMapping("/menuAdd")
    public AppResponse menuAdd(MenuData menuData)
    {
        try
        {
            String userId = AuthUtils.getCurrentUserId();  //----
            menuData.setCreateBy(userId);   //---
            AppResponse appResponse = menuService.menuAdd(menuData);  //对应dao的方法
            return appResponse;
        }catch (Exception e)
        {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 菜单列表
     * @param menuData
     * @return
     */

    @RequestMapping(value = "menuListCheck")
    public AppResponse menuListCheck(MenuData menuData) {
        try {
            return menuService.menuListCheck(menuData);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * //菜单删除
     * @param menuId
     * @return
     */
    @PostMapping("menuDelete")
    public AppResponse menuDelete(String menuId) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return menuService.menuDelete(menuId,userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 菜单修改
     * @param menuData
     * @return
     */
    @PostMapping("menuUpdate")
    public AppResponse menuUpdate(MenuData menuData) {
        try {
            //获取用户id
            String menuId = AuthUtils.getCurrentUserId();
            menuData.setCreateBy(menuId);
            menuData.setCreateBy(menuId);
            return menuService.menuUpdate(menuData);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 菜单详情
     * @param menuId
     * @return
     */
    @RequestMapping(value = "getMenuByMenuId")
    public AppResponse getMenuByMenuId(String menuId) {
        try {
            return menuService.getMenuByMenuId(menuId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
