package com.xzsd.pc.order.dao;
import com.xzsd.pc.order.entity.OrderData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 订单ID数量
     * @param orderData
     * @return
     */
    int countOrderId(OrderData orderData);
    /**
     * 新增订单
     * @param orderData
     * @return
     */
    int orderAdd(OrderData orderData);
    /**
     * 订单列表
     * @param orderData
     * @return
     */
    List<OrderData> orderListCheck(OrderData orderData);
    /**
     * 订单删除
     * @param listId
     * @param userId
     * @return
     */
    int orderDelete(@Param("listId") List<String> listId, @Param("userId") String userId);
    /**
     * 订单修改
     * @param orderData
     * @return
     */
    int orderUpdate(OrderData orderData);
    /**
     * 订单详情
     * @param orderId
     * @return
     */
    OrderData getOrderByOrderId(@Param("orderId") String orderId);
}
