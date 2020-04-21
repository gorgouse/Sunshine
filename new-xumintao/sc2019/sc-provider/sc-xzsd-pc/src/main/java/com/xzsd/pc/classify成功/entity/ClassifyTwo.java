package com.xzsd.pc.classify成功.entity;

import java.util.Date;

public class ClassifyTwo {
    /**
     * 单页的数量
     */
    private int pageSize;
    /**
     * 页数
     */
    private int PageNum;
    /**
     * 分类ID
     */
    private String classifyId;

    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 父级分类
     */
    private String parentId;
    /**
     * 分类等级
     */
    private int classifyLevel;




    /**
     * 注释
     */
    private String comment;
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

    public String getClassifyId() {
        return this.classifyId;
    }

    public void setClassifyId( String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return this.classifyName;
    }

    public void setClassifyName( String classifyName) {
        this.classifyName = classifyName;
    }

    public int getClassifyLevel() {
        return this.classifyLevel;
    }

    public void setClassifyLevel( int classifyLevel) {
        this.classifyLevel = classifyLevel;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment( String comment) {
        this.comment = comment;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId( String parentId) {
        this.parentId = parentId;
    }

    public int getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete( int isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime( Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy( String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime( Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy( String updateBy) {
        this.updateBy = updateBy;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion( int version) {
        this.version = version;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize( int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return this.PageNum;
    }

    public void setPageNum( int pageNum) {
        this.PageNum = pageNum;
    }
}
