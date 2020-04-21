package com.xzsd.pc.order.entity;

import java.util.Date;

public class OrderData {

    /**
     * 订单id
     */
    private String orderId;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 下单人id
     */
    private String userId;
    /**
     * 登录者Id
     */
    private String loginUserId;
    /**
     * 支付时间起
     */
    private String payTimeStart;
    /**
     * 支付时间止
     */
    private String payTimeEnd;
    /**
     * 下单人电话
     */
    private String phone;
    /**
     * 订单状态(0已下单， 1待取货， 2已取货， 3已完成未评价， 4已完成已评价， 5已取消)
     */
    private String orderStateId;
    /**
     * 角色编号（当前登录的角色）
     */
    private String role;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 支付状态
     */
    private String defrayStatus;
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 支付时间
     */
    private String payTime;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 作废标记 0为存在，1为作废
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



    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId( String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName( String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }

    public String getLoginUserId() {
        return this.loginUserId;
    }

    public void setLoginUserId( String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getPayTimeStart() {
        return this.payTimeStart;
    }

    public void setPayTimeStart( String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return this.payTimeEnd;
    }

    public void setPayTimeEnd( String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone( String phone) {
        this.phone = phone;
    }

    public String getOrderStateId() {
        return this.orderStateId;
    }

    public void setOrderStateId( String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole( String role) {
        this.role = role;
    }

    public String getOrderAllCost() {
        return this.orderAllCost;
    }

    public void setOrderAllCost( String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getDefrayStatus() {
        return this.defrayStatus;
    }

    public void setDefrayStatus( String defrayStatus) {
        this.defrayStatus = defrayStatus;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId( String storeId) {
        this.storeId = storeId;
    }

    public String getPayTime() {
        return this.payTime;
    }

    public void setPayTime( String payTime) {
        this.payTime = payTime;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize( int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum( int pageNum) {
        this.pageNum = pageNum;
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

    public void setUpdateBy( String updateBy) {
        this.updateBy = updateBy;
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
