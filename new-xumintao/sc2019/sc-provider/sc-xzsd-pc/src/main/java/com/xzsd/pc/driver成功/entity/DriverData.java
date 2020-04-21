package com.xzsd.pc.driver成功.entity;

import java.util.Date;

public class DriverData {

    private int pageSize;
    private int pageNum;
    /**
     * 司机编号
     */
    private String driverId;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 司机账号
     */
    private String driverAccount;
    /**
     * 司机密码
     */
    private String driverPassword;
    /**
     * 身份证
     */
    private String identity;
    /**
     * 司机电话号码
     */
    private String phone;
    /**
     * 省市区ID
     */
    private String provinceCode;
    private String cityCode;
    private String areaCode;
    /**
     * 省市区名称
     */
    private String provinceName;
    private String cityName;
    private String areaName;
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
    private int version;




    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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

    public int getVersion() { return version; }

    public void setVersion(int version) {
        this.version = version;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAccount() {
        return driverAccount;
    }

    public void setDriverAccount(String driverAccount) {
        this.driverAccount = driverAccount;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode(final String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(final String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(final String areaCode) {
        this.areaCode = areaCode;
    }
}
