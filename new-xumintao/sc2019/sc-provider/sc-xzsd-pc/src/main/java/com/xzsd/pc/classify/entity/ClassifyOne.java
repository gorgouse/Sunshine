package com.xzsd.pc.classify.entity;

import java.util.Date;
import java.util.List;

public class ClassifyOne {
    /**
     * 一级分类ID
     */
    private String oneClassifyId;
    /**
     * 一级分类名称
     */
    private String oneClassifyName;
    /**
     * 注释
     */
    private String comment;
    /**
     * 二级分类列表
     */
    private List<ClassifyTwo> ifTwoClassifyList;
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

    public String getOneClassifyName() {
        return this.oneClassifyName;
    }

    public void setOneClassifyName(final String oneClassifyName) {
        this.oneClassifyName = oneClassifyName;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public List<ClassifyTwo> getIfTwoClassifyList() {
        return this.ifTwoClassifyList;
    }

    public void setIfTwoClassifyList(final List<ClassifyTwo> ifTwoClassifyList) {
        this.ifTwoClassifyList = ifTwoClassifyList;
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
}
