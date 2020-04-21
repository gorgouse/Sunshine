package com.xzsd.pc.user成功.entity;

import java.util.Date;

public class UserData {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */

    private int pageNumber;



    /**
     * 用户ID
     */
     private String userId;
    /**
     * 用户名称
     */
     private String userName;
    /**
     * 用户账号
     */
     private String userAccount;
    /**
     * 用户密码
     */
     private String userPassword;

    /**
     * 用户角色  (0超级管理员，1管理员，2店长，3司机，4用户）
     */
    private String role;

    /**
     * 图片路径
     */
    private String imagePath;

    /**
     * 用户头像
     */
    private String userImage;

    /**
     * 身份证号码
     */

     private String identity;
    /**
     * 性别0男 1女
     */
     private String sex;
    /**
     * 手机号码
     */
     private String phone;
    /**
     * 电子邮件
     */
     private String email;
    /**
     * 备注
     */
     private String remark;



    /**
     * 序号
     */
    private int sortNumber;

    /**
     * 作废标记 0为存在 ，1为作废
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


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) { this.pageNumber = pageNumber; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public String getIdentity() {
        return identity;
    }
///
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIsDeleted() {
        return isDelete;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDelete = isDeleted;
    }

    public int getSortNo() {
        return sortNumber;
    }

    public void setSortNo(int sortNo) {
        this.sortNumber = sortNumber;
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

    public int  getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public String getUserImage() {
        return this.userImage;
    }

    public void setUserImage( String userImage) {
        this.userImage = userImage;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex( String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(int sortNumber) {
        this.sortNumber = sortNumber;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}


























