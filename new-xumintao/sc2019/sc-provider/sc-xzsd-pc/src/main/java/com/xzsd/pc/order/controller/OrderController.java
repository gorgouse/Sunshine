package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderData;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    OrderService orderService;

    /**
     * 订单列表
     * @param orderData
     * @return
     */
    @RequestMapping(value = "orderListCheck")
    public AppResponse orderListCheck(OrderData orderData) {
        try {
            String currentUser = SecurityUtils.getCurrentUserId();
            orderData.setLoginUserId(currentUser);
            return AppResponse.success("订单列表查询成功",orderService.orderListCheck(orderData));
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
