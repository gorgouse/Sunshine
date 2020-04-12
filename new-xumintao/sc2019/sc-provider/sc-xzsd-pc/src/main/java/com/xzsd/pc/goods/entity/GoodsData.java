package com.xzsd.pc.goods.entity;

import java.util.Date;

public class GoodsData {

    private int pageSize;

    private int pageNum;

    private String goodsId;



    private String goodsName;
    //成本价
    private int costPrice;
    //售价
    private int goodsPrice;


    private int goodsState;

    private String writer;

    private String goodsAdvertise;

    private String press;


    private String oneClassifyId;

    private String twoClassifyId;

    private String goodsAdvertisement;

    private String goodsIntroduction;

    private String merchantName;

    private int goodsInventory;

    private int callNumber;

    private String picture;


    /**
     * 序号
     */
    private int sortNumber;
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

    public int getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
    }

    public String getGoodsAdvertise() {
        return goodsAdvertise;
    }

    public void setGoodsAdvertise(String goodsAdvertise) {
        this.goodsAdvertise = goodsAdvertise;
    }

    public String getOneClassifyId() {
        return oneClassifyId;
    }

    public void setOneClassifyId(String oneClassifyId) {
        this.oneClassifyId = oneClassifyId;
    }

    public String getTwoClassifyId() {
        return twoClassifyId;
    }

    public void setTwoClassifyId(String twoClassifyId) {
        this.twoClassifyId = twoClassifyId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public int getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(int sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getGoodsId() { return goodsId; }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() { return goodsName; }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public int getCostPrice() { return costPrice; }

    public void setCostPrice( int costPrice) {
        this.costPrice = costPrice;
    }

    public int getGoodsPrice() { return goodsPrice; }


    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }



    public void setGoodsPrice( int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }


    public String getGoodsAdvertisement() { return goodsAdvertisement; }

    public void setGoodsAdvertisement(String goodsAdvertisement) {
        this.goodsAdvertisement = goodsAdvertisement;
    }

    public String getGoodsIntroduction() { return goodsIntroduction; }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }

    public int getGoodsInventory() { return goodsInventory; }

    public void setGoodsInventory( int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public int getCallNumber() { return callNumber; }

    public void setCallNumber( int callNumber) {
        this.callNumber = callNumber;
    }

    public String getPicture() { return picture; }

    public void setPicture( String picture) {
        this.picture = picture;
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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

























}
