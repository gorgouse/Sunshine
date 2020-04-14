package com.xzsd.pc.classify.dao;


import com.xzsd.pc.classify.entity.ClassifyData;
import com.xzsd.pc.classify.entity.ClassifyOne;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassifyDao {
    /**
     * 查询相同的商品分类id的数量
     * @param classifyData
     * @return
     */
    int countClassifyId(ClassifyData classifyData);  //增，改
    /**
     * 商品分类新增
     * @param classifyData
     * @return
     */
    int classifyAdd(ClassifyData classifyData);  //增
    /**
     * 查询二级分类的数量
     * @param classifyId
     * @return
     */
    int countTwoClassify(String classifyId);
    /**
     *商品分类列表查询
     * @param
     * @return
     */
    List<ClassifyOne> classifyListCheck();
    /**
     * 删除分类
     * @param classifyData
     * @return
     */
    int classifyDelete(ClassifyData classifyData);

    /**
     * 商品分类修改
     * @param classifyData
     * @return
     */
    int classifyUpdate(ClassifyData classifyData);

    /**
     * 商品详情
     * @param classifyId
     * @return
     */
    ClassifyData getClassifyByClassifyId(@Param("classifyId") String classifyId);
}
