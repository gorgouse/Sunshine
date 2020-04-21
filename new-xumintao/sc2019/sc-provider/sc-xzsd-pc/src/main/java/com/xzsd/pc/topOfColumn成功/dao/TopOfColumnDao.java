package com.xzsd.pc.topOfColumn成功.dao;


import com.xzsd.pc.topOfColumn成功.entity.TopOfColumnData;
import org.apache.ibatis.annotations.Param;

public interface TopOfColumnDao {
    /**
     * 获取顶部栏
     * @param topOfColumnData
     * @return
     */
    TopOfColumnData  getTopOfColumn(TopOfColumnData topOfColumnData,@Param("userCode") String userCode);
}
