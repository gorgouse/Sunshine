package com.xzsd.pc.hotGoods.entity;

import java.util.Date;

public class HotGoodsData {
    /**
     * 单页的数据量
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 热门商品ID
     */
    private String hotGoodsId;
    /**
     * 热门商品数
     */
    private int hotGoodsNum;
    /**
     * 热门商品介绍
     */
    private String hotGoodsIntroduction;
    /**
     * 排序
     */
    private int sort;
    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 售价
     */
    private String goodsPrice;
    /**
     * 起始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 作废标记
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 版本号
     */
    private int version;


    public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName(final String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return this.goodsPrice;
    }

    public void setGoodsPrice(final String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getHotGoodsIntroduction() {
        return this.hotGoodsIntroduction;
    }

    public void setHotGoodsIntroduction(final String hotGoodsIntroduction) {
        this.hotGoodsIntroduction = hotGoodsIntroduction;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getHotGoodsId() {
        return hotGoodsId;
    }

    public void setHotGoodsId(String hotGoodsId) {
        this.hotGoodsId = hotGoodsId;
    }

    public int getHotGoodsNum() {
        return hotGoodsNum;
    }

    public void setHotGoodsNum(int hotGoodsNum) {
        this.hotGoodsNum = hotGoodsNum;
    }

    public int getSort() {
        return this.sort;
    }

    public void setSort(final int sort) {
        this.sort = sort;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

}
