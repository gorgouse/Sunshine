package com.xzsd.pc.slideShow.entity;


import java.util.Date;

public class SlideShowData {
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 。单页数据
     */
    private int  pageSize;
    /**
     * 轮播图ID
     */
    private String slideShowId;
    /**
     * 排序
     */
    private int sort;
    /**
     * 轮播图状态
     */
    private int slideShowState;
    /**
     * 图片路径
     */
    private String picturePath;
    /**
     * 预览
     */
    private String preview;
    /**
     * 有效期起
     */
    private Date startTime;
    /**
     * 有效期止
     */
    private Date endTime;//有效期止

















    private int isDelete;
    /**
     * 序号
     */
    private int sortNumber;
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
    private String version;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSlideShowId() {
        return slideShowId;
    }

    public void setSlideShowId(String slideShowId) {
        this.slideShowId = slideShowId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getSlideShowState() {
        return slideShowState;
    }

    public void setSlideShowState(int slideShowState) {
        this.slideShowState = slideShowState;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
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
        endTime = endTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(int sortNumber) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }




}
