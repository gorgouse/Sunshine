package com.xzsd.pc.menu成功.entity;

import java.util.Date;

public class MenuData {
    /**
     * 单页的数据数
     */
    private int pageSize;
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 是否是店长
     */
    private String isShopMnager;
    /**
     * 角色
     */
    private String role;
    /**
     * 菜单ID
     */
    private String menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单路由
     */
    private String menuPath;
    /**
     * 是否菜单
     */
    private int isMenu;
    /**
     * 父类菜单
     */
    private String parentMenu;
    /**
     * 菜单备注
     */
    private String menuComment;
    /**
     * 作废标记
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 版本号
     */
    private String version;


    public String getIsShopMnager() {
        return this.isShopMnager;
    }

    public void setIsShopMnager(final String isShopMnager) {
        this.isShopMnager = isShopMnager;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }


    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }


    public int getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(int isMenu) {
        this.isMenu = isMenu;
    }


    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }


    public String getMenuComment() {
        return menuComment;
    }

    public void setMenuComment(String menuComment) {
        this.menuComment = menuComment;
    }





    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }




    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }



    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }






























}
