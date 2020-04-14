package com.xzsd.pc.store.entity;

import java.util.Date;

public class StoreData {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 单页的数据量
     */
    private int pageSize;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 电话
     */
    private String phone;
    /**
     * 门店地址
     */
    private String address;
    /**
     * 门店邀请码
     */
    private String inviteCode;
    /**
     *门店账号（店长账号）
     */
    private String storeManagerAccount;
    /**
     * 营业执照编码
     */
    private String bussinessLicenseId;
    /**
     * 店长名称
     */
    private String storeManagerName;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 省级编号
     */
    private String provinceId;
    /**
     * 市级编号
     */
    private String cityId;
    /**
     * 区级编号
     */
    private String areaId;
    /**
     * 角色
     */
    private String role;
    /**
     * 作废标记
     */
    private int isDelete;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updateBY;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 版本号
     */

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum( int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize( int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId( String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName( String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone( String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress( String address) {
        this.address = address;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public void setInviteCode( String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getStoreManagerAccount() {
        return this.storeManagerAccount;
    }

    public void setStoreManagerAccount( String storeManagerAccount) {
        this.storeManagerAccount = storeManagerAccount;
    }

    public String getBussinessLicenseId() {
        return this.bussinessLicenseId;
    }

    public void setBussinessLicenseId( String bussinessLicenseId) {
        this.bussinessLicenseId = bussinessLicenseId;
    }

    public String getStoreManagerName() {
        return this.storeManagerName;
    }

    public void setStoreManagerName( String storeManagerName) {
        this.storeManagerName = storeManagerName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName( String userName) {
        this.userName = userName;
    }

    public String getProvinceId() {
        return this.provinceId;
    }

    public void setProvinceId( String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId( String cityId) {
        this.cityId = cityId;
    }

    public String getAreaId() {
        return this.areaId;
    }

    public void setAreaId( String areaId) {
        this.areaId = areaId;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole( String role) {
        this.role = role;
    }

    public int getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete( int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy( String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime( Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBY() {
        return this.updateBY;
    }

    public void setUpdateBY( String updateBY) {
        this.updateBY = updateBY;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime( Date updateTime) {
        this.updateTime = updateTime;
    }
}
