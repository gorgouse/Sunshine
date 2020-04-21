package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 订单列表
     *
     */
    List<OrderData> orderListCheck(OrderData orderData);
    /**
     * 订单详情
     */
    OrderData getOrderByOrderId(@Param("orderId")String orderId);
    /**
     * 修改订单状态
     */
   // int orderUPdate(@Param("listId") )
}
