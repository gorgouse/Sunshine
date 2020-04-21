package com.xzsd.pc.store算成功.entity;

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
    private String bussinessLicenseCode;
    /**
     * 店长ID
     */
    private String storeManagerId;
    /**
     * 店长名称
     */
    private String storeManagerName;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 省级编号
     */
    private String provinceCode;
    /**
     * 省级名称
     */
    private System provinceName;
    /**
     * 市级编号
     */
    private String cityCode;
    /**
     * 市级名称
     */
    private String cityName;
    /**
     * 区级编号
     */
    private String areaCode;
    /**
     * 区级名称
     */
    private String areaName;
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
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;


    public String getUserId() {
        return this.userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setBussinessLicenseCode(final String bussinessLicenseCode) {
        this.bussinessLicenseCode = bussinessLicenseCode;
    }

    public String getStoreManagerId() {
        return this.storeManagerId;
    }

    public void setStoreManagerId(final String storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

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

    public String getBussinessLicenseCode() {
        return this.bussinessLicenseCode;
    }

    public void setBussinessLicenseId( String bussinessLicenseId) {
        this.bussinessLicenseCode = bussinessLicenseId;
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

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode( String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode( String cityId) {
        this.cityCode= cityCode;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode( String areaCode) {
        this.areaCode = areaCode;
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

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(final String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime( Date updateTime) {
        this.updateTime = updateTime;
    }

    public System getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(final System provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(final String areaName) {
        this.areaName = areaName;
    }
}
