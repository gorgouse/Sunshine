package com.xzsd.pc.driver成功.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.driver成功.entity.DriverData;
import com.xzsd.pc.driver成功.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;


    /**
     * 新增司机
     * @param driverData
     * @return
     */
    @PostMapping("/driverAdd")
    public AppResponse driverAdd(DriverData driverData ) {
        try {
            //获取用户id
            String driverID = AuthUtils.getCurrentUserId();
            driverData.setCreateBy(driverID);
            AppResponse appResponse = driverService.driverAdd(driverData);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * 司机列表
     * @param driverData
     * @return
     */
    @RequestMapping(value = "driverListCheck")
    public AppResponse driverListCheck (DriverData driverData){
        try {
            return driverService.driverListCheck(driverData);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机
     * @param driverId
     * @return
     */
    @PostMapping("driverDelete")
    public AppResponse driverDelete (String driverId){
        try {
            String userCode = AuthUtils.getCurrentUserId();
            return driverService.driverDelete(driverId,userCode);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机信息
     * @param driverData
     * @return
     */
    @PostMapping("driverUpdate")
    public AppResponse goodsUpdate(DriverData driverData) {
        try {
            String driverId = AuthUtils.getCurrentUserId();
            driverData.setCreateBy(driverId);
            return driverService.driverUpdate(driverData);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
          }  }

    /**
     *司机详情
     * @param driverId
     * @return
     */
    @RequestMapping(value = "getDriverByDriverId")
    public AppResponse getDriverByDriverI(String driverId) {
        try {
            return driverService.getDriverByDriverId(driverId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
