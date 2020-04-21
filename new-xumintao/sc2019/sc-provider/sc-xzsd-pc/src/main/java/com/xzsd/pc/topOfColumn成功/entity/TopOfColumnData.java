package com.xzsd.pc.topOfColumn成功.entity;

import java.util.Date;

public class TopOfColumnData {
    /**
     * 用户名称
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 用户图片
     */
    private String userImage;

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
    private String version;


    public String getUserId() {
        return this.userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName( String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole( String role) {
        this.role = role;
    }

    public String getUserImage() {
        return this.userImage;
    }

    public void setUserImage( String userImage) {
        this.userImage = userImage;
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

    public String getVersion() {
        return this.version;
    }

    public void setVersion( String version) {
        this.version = version;
    }
}
