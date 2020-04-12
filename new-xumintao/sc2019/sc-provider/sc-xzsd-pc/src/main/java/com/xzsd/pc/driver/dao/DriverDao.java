package com.xzsd.pc.driver.dao;



import com.xzsd.pc.driver.entity.DriverData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverDao {

    int countDriverAccount(DriverData driverData);


    int driverAdd(DriverData driverData);


    List<DriverData> driverListCheck(DriverData driverData);//列表查询

    int driverDelete(@Param("listId") List<String> listId, @Param("userCode") String userCode); //删除


    int driverUpdate(DriverData driverData); //修改




    DriverData getDriverByDriverId(@Param("driverId") String driverId); //注释

}
