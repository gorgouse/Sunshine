package com.xzsd.pc.menu成功.comtroller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu成功.entity.MenuData;
import com.xzsd.pc.menu成功.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
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
            String userId = SecurityUtils.getCurrentUserId();
            menuData.setCreateBy(userId);
           return menuService.menuAdd(menuData);

        }catch (Exception e)
        {
            logger.error("菜单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }




    @RequestMapping(value = "menuListCheck")
    public AppResponse menuListCheck() {
        try {
            return menuService.menuListCheck();
        } catch (Exception e) {
            logger.error("查询菜单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    @PostMapping("menuDelete")
    public AppResponse menuDelete(String menuId) {
        try {
            //获取用户id
            String currentUserId = SecurityUtils.getCurrentUserId();
            return menuService.menuDelete(menuId,currentUserId);
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    @PostMapping("menuUpdate")
    public AppResponse menuUpdate(MenuData menuData) {
        try {
            //获取用户id
            String currentUserId = SecurityUtils.getCurrentUserId();
            menuData.setUpdateBy(currentUserId);
            return menuService.menuUpdate(menuData);
        } catch (Exception e) {
            logger.error("修改菜单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    @RequestMapping(value = "getMenuByMenuId")
    public AppResponse getMenuByMenuId(String menuId) {
        try {
            return menuService.getMenuByMenuId(menuId);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    @PostMapping("listMenuHome")
    public AppResponse getPageHomeMenu(String role){
        try {
            return menuService.getPageHomeMenu(role);
        }catch (Exception e){
            logger.error("根据角色查询菜单失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
