package com.xzsd.pc.classify.entity;

import java.util.Date;
import java.util.List;

public class ClassifyData {
    /**
     * 单页的数量
     */
    private int pageSize;
    /**
     * 页数
     */
    private int PageNum;
    /**
     * 一级分类ID
     */
   private String oneClassifyId;
    /**
     * 分类ID
     */
   private String classifyId;
    /**
     * 分类名称
     */
   private String classifyName;
    /**
     * 分类等级
     */
   private String classifyLevel;
    /**
     * 注释
     */
   private String comment;
    /**
     * 父级分类
     */
    private String parentId;
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


    public String getOneClassifyId() {
        return this.oneClassifyId;
    }

    public void setOneClassifyId(final String oneClassifyId) {
        this.oneClassifyId = oneClassifyId;
    }

    public String getClassifyId() {
        return this.classifyId;
    }

    public void setClassifyId(final String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return this.classifyName;
    }

    public void setClassifyName(final String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyLevel() {
        return this.classifyLevel;
    }

    public void setClassifyLevel(final String classifyLevel) {
        this.classifyLevel = classifyLevel;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(final String parentId) {
        this.parentId = parentId;
    }

    public int getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(final int isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(final String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(final Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(final String updateBy) {
        this.updateBy = updateBy;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return this.PageNum;
    }

    public void setPageNum(final int pageNum) {
        this.PageNum = pageNum;
    }
}
