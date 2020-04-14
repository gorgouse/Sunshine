package com.xzsd.pc.order.entity;

import java.util.Date;

public class OrderData {
    /**
     * 单页的数量
     */
    private int pageNum;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品数量
     */
    private int goodsCount;
    /**
     * 总金额
     */
    private String totalSum;
    /**
     * 售价
     */
    private String goodsSale;
    /**
     * 定价
     */
    private String goodsPrice;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 付款日期起
     */
    private String payTimeStart;
    /**
     * 付款日期止
     */
    private String getPayTimeEnd;
    /**
     * 角色编号
     */
    private String role;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 确认付款时间
     */
    private String payTime;
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


    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize( int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId( String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId( String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId( String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName( String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsCount() {
        return this.goodsCount;
    }

    public void setGoodsCount( int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getTotalSum() {
        return this.totalSum;
    }

    public void setTotalSum( String totalSum) {
        this.totalSum = totalSum;
    }

    public String getGoodsSale() {
        return this.goodsSale;
    }

    public void setGoodsSale( String goodsSale) {
        this.goodsSale = goodsSale;
    }

    public String getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice( String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName( String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone( String phone) {
        this.phone = phone;
    }

    public String getPayTimeStart() {
        return this.payTimeStart;
    }

    public void setPayTimeStart( String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getGetPayTimeEnd() {
        return this.getPayTimeEnd;
    }

    public void setGetPayTimeEnd( String getPayTimeEnd) {
        this.getPayTimeEnd = getPayTimeEnd;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole( String role) {
        this.role = role;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public void setStoreId( String storeId) {
        this.storeId = storeId;
    }

    public String getOrderState() {
        return this.orderState;
    }

    public void setOrderState( String orderState) {
        this.orderState = orderState;
    }

    public String getPayTime() {
        return this.payTime;
    }

    public void setPayTime( String payTime) {
        this.payTime = payTime;
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
