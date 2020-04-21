package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods成功.entity.GoodsData;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderData;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 订单列表查询
     */
    public AppResponse orderListCheck(OrderData orderData)
    {
        PageHelper.startPage(orderData.getPageNum(), orderData.getPageSize());
        List<OrderData> orderDataList =orderDao.orderListCheck(orderData);

        PageInfo<OrderData> pageData = new PageInfo<OrderData>(orderDataList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 订单详情
     */
    public AppResponse getOrderByOrderId(String orderId)
    {
            OrderData orderData = orderDao.getOrderByOrderId(orderId);

    }
}
