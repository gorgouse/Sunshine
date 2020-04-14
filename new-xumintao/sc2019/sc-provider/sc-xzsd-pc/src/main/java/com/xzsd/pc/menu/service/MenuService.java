package com.xzsd.pc.menu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.comtroller.MenuController;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    /**
     * 菜单新增
     * @param menuData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse menuAdd(MenuData menuData)
    {
        menuData.setMenuId(StringUtil.getCommonCode(2));
        menuData.setIsDelete(0);
        int count =  menuDao.menuAdd(menuData);
        if (0 == count) {
            return AppResponse.success("菜单新增失败，请重试！");
        }
        return AppResponse.success("菜单新增成功！");
    }

    /**
     * 菜单列表查询
     * @param menuData
     * @return
     */
    public AppResponse menuListCheck(MenuData menuData) {
        PageHelper.startPage(menuData.getPageNum(), menuData.getPageSize());  //静态方法，传递两个参数（当前页码，每页查询条数）
        List<MenuData> menuDataList = menuDao.menuListCheck(menuData);
        // 包装Page对象
        PageInfo<MenuData> pageData = new PageInfo<MenuData>(menuDataList);          //返回的信息就是pageInfo对象，该类是插件里的类，
        return AppResponse.success("菜单查询成功！", pageData);
    }

    /**
     * 菜单删除
     * @param menuId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse menuDelete(String menuId, String userId) {
        List<String> listId = Arrays.asList(menuId.split(","));  //？
        int count = menuDao.menuDelete(listId,userId);
        if (0 == count) {
            return AppResponse.bizError("菜单删除失败，请重试！");
        }
        return AppResponse.success("菜单删除成功！");
    }

    /**
     * 菜单修改
     * @param goodsData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse menuUpdate(MenuData goodsData) {
        AppResponse appResponse = AppResponse.success("菜单修改成功");

        int count = menuDao.menuUpdate(goodsData);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 菜单详情
     * @param goodsId
     * @return
     */
    public AppResponse getMenuByMenuId(String goodsId)
    {
       MenuData goodsData =  menuDao.getMenuByMenuId(goodsId);
        return AppResponse.success("菜单查询成功！", goodsData);
    }
}
