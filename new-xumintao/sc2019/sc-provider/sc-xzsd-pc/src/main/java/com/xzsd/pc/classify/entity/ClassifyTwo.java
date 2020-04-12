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
}
