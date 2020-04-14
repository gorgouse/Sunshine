package com.xzsd.pc.classify.entity;

import java.util.Date;
import java.util.List;

public class ClassifyTwo {
    /**
     * 二级分类Id
     */
    private String twoClassifyId;
    /**
     * 二级分类名称
     */
    private String twoClassifyName;
    /**
     * 父类ID
     */
    private String parentId;
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


    public String getTwoClassifyId() {
        return this.twoClassifyId;
    }

    public void setTwoClassifyId( String twoClassifyId) {
        this.twoClassifyId = twoClassifyId;
    }

    public String getTwoClassifyName() {
        return this.twoClassifyName;
    }

    public void setTwoClassifyName( String twoClassifyName) {
        this.twoClassifyName = twoClassifyName;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId( String parentId) {
        this.parentId = parentId;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment( String comment) {
        this.comment = comment;
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
}
