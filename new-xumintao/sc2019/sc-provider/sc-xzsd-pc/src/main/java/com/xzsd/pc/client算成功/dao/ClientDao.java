package com.xzsd.pc.client算成功.dao;

import com.xzsd.pc.client算成功.entity.ClientData;

import java.util.List;

public interface ClientDao {

    /**
     * 查询当前登录用户是店长时的所有客户信息
     * @param clientData
     * @return
     */
    List<ClientData> getListCustomers(ClientData clientData);

    /**
     * 查询登录者为管理员时的用户列表
     * @param clientData
     * @return
     */
    List<ClientData> getListCustomersByAdmin(ClientData clientData);
}
