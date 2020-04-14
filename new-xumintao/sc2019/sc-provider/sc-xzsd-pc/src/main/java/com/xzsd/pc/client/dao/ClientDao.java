package com.xzsd.pc.client.dao;

import com.xzsd.pc.client.entity.ClientData;

import java.util.List;

public interface ClientDao {
    /**
     * 客户列表查询
     * @param clientData
     * @return
     */
    List<ClientData> clientListCheck(ClientData clientData);
}
