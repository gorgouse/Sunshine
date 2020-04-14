package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.entity.GoodsData;
import com.xzsd.pc.order.controller.OrderController;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * 新增订单
     * @param orderData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderAdd(OrderData orderData)
    {
        int countOrderId = orderDao.orderAdd(orderData);
        if (0 != countOrderId) {
            return AppResponse.success("新增的订单已存在，请再次尝试");
        }

        orderData.setOrderId(StringUtil.getCommonCode(2));
        orderData.setIsDelete(0);

        int count = orderDao.orderAdd(orderData);
        if (0 == count) {
            return AppResponse.success("订单新增失败，请重试！");
        }
        return AppResponse.success("订单新增成功！");
    }

    /**
     * 订单列表查询
     * @param orderData
     * @return
     */
    public AppResponse orderListCheck(OrderData orderData) {
        PageHelper.startPage(orderData.getPageNum(), orderData.getPageSize());
        List<OrderData> orderDataList = orderDao.orderListCheck(orderData);
        PageInfo<OrderData> pageData = new PageInfo<OrderData>(orderDataList);
        return AppResponse.success("订单查询成功！", pageData);
    }

    /**
     * 订单删除
     * @param orderId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderDelete(String orderId, String userId) {
        List<String> listId = Arrays.asList(orderId.split(","));
        int count = orderDao.orderDelete(listId, userId);
        if (0 == count) {
            return AppResponse.bizError("订单删除失败，请重试！");
        }
        return AppResponse.success("订单删除成功！");
    }


    /**
     * 订单修改
     * @param orderData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderUpdate(OrderData orderData) {
        AppResponse appResponse = AppResponse.success("订单修改成功");
        int countOrderId = orderDao.countOrderId(orderData);
        if (0 != countOrderId) {
            return AppResponse.success("新增的订单已存在，请再次尝试");
        }
        int count = orderDao.orderUpdate(orderData);
        if (0 == count) {
            appResponse = AppResponse.versionError("订单数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    public AppResponse getOrderByOrderId(String orderId) {

        OrderData orderData = orderDao.getOrderByOrderId(orderId);
        return AppResponse.success("查询成功！", orderData);


    }
}