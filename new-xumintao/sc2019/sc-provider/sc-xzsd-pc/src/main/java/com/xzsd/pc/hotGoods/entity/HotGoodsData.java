package com.xzsd.pc.hotGoods.entity;

import java.util.Date;

public class HotGoodsData {
    private int pageSize;
    /**
     * 页数
     */
    private int pageNumber;

    private String hotGoodsId;

    private int hotGoodsNum;

    private String goodsId;

    private Date startTime;

    private Date endTime;

    private int isDelete;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private int version;


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
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
