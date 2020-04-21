package com.xzsd.pc.menu成功.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu成功.dao.MenuDao;
import com.xzsd.pc.menu成功.entity.MenuData;
import com.xzsd.pc.menu成功.entity.MenuList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;

    /**
     * 菜单新增
     *
     * @param menuData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse menuAdd(MenuData menuData) {


        //判断是否存在相同的菜单路由
        int countMenuUrl = menuDao.countMenuUrl(menuData);
        if(0 != countMenuUrl){
            return AppResponse.versionError("存在相同的菜单路由，请重新输入");
        }

        //生成菜单编码
        menuData.setMenuId(StringUtil.getCommonCode(2));

        int result = menuDao.menuAdd(menuData);
        if (0 == result)
        {
                return AppResponse.versionError("菜单新增失败，请重试！");
        }
            return AppResponse.success("菜单新增成功！");
        }

    /**
     * 菜单列表
     * @return
     */
        public AppResponse menuListCheck ()
        {
            List<MenuData> menuDataList = menuDao.menuListCheck();
            if(menuDataList.size() == 0){
                return AppResponse.versionError("查询菜单列表失败！");
            }
            MenuList menuList = new MenuList();
            menuList.setMenuList(menuDataList);
            return AppResponse.success("菜单查询成功！", menuList);
        }

    /**
     * 菜单删除
     * @param menuId
     * @param currentUserId
     * @return
     */
        @Transactional(rollbackFor = Exception.class)
        public AppResponse menuDelete (String menuId, String currentUserId)
        {

            int count = menuDao.menuDelete(menuId,currentUserId);
            if (0 == count)
            {
                return AppResponse.bizError("菜单删除失败，请重试！");
            }
            return AppResponse.success("菜单删除成功！");
        }


    /**
     * 菜单修改
     * @param menudata
     * @return
     */
        @Transactional(rollbackFor = Exception.class)
        public AppResponse menuUpdate (MenuData menudata)
        {
            /*
            MenuData menuInfo = menuDao.getMenuByMenuId(menudata.getMenuId());

            if(menuInfo.getMenuName().equals(menudata.getMenuName()) == false){
                //判断是否存在相同的菜单名
                int count = menuDao.countMenuName(menudata);
                if(0 != count){
                    return AppResponse.versionError("存在相同的菜单名，请重新输入");
                }
            }
            if(menuInfo.getMenuPath().equals(menudata.getMenuPath()) == false){
                //判断是否存在相同的菜单路由
                int countMenuUrl = menuDao.countMenuUrl(menudata);
                if( 0 != countMenuUrl){
                    return AppResponse.versionError("存在相同的菜单路由，请重新输入");
                }
            }
           */
            int updateMenu = menuDao.menuUpdate(menudata);
            if(0 == updateMenu)
            {
                return AppResponse.versionError("修改菜单失败");
            }
            return AppResponse.success("修改菜单成功");
        }


    /**
     * 菜单详情
     * @param menuId
     * @return
     */
        public AppResponse getMenuByMenuId (String menuId)
        {
            MenuData menuData = menuDao.getMenuByMenuId(menuId);
            if(menuData == null)
            {
                return AppResponse.versionError("查询用户失败");
            }
            return AppResponse.success("菜单查询成功！", menuData);
        }


    /**
     * 角色菜单查询
     * @param role
     * @return
     */
    public AppResponse getPageHomeMenu(String role){
        List<MenuData> pageHomeMenu = menuDao.getPageHomeMenu(role);
        if(pageHomeMenu.size() == 0){
            return AppResponse.versionError("角色查询菜单失败");
        }
        //封装数据
        MenuList menuList = new MenuList();
        menuList.setMenuList(pageHomeMenu);
        return AppResponse.success("角色查询菜单成功", menuList);
    }

}