package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goods.controller.GoodsController;
import com.xzsd.pc.goods.entity.GoodsData;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.order.entity.OrderData;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * 订单新增
     * @param orderData
     * @return
     */
    @PostMapping("/orderAdd")
    public AppResponse orderAdd(OrderData orderData)
    {
        try
        {
            //获取商品id
            String orderId = AuthUtils.getCurrentUserId();  //----
            orderData.setCreateBy(orderId);   //---
            AppResponse appResponse =orderService.orderAdd(orderData);  //对应dao的方法
            return appResponse;
        }catch (Exception e)
        {
            logger.error("订单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单列表
     * @param orderData
     * @return
     */
    @RequestMapping(value = "orderListCheck")
    public AppResponse orderListCheck(OrderData orderData) {
        try {
            return orderService.orderListCheck(orderData);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @PostMapping("orderDelete")
    public AppResponse orderDelete(String orderId) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return orderService.orderDelete(orderId,userId);
        } catch (Exception e) {
            logger.error("订单删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单
     * @param orderData
     * @return
     */
    @PostMapping("orderUpdate")
    public AppResponse orderUpdate(OrderData orderData) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            orderData.setCreateBy(userId);
            return orderService.orderUpdate(orderData);
        } catch (Exception e) {
            logger.error("修改订单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "getOrderByOrderId")
    public AppResponse getOrderByOrderId(String orderId) {
        try {
            return orderService.getOrderByOrderId(orderId);
        } catch (Exception e) {
            logger.error("订单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
