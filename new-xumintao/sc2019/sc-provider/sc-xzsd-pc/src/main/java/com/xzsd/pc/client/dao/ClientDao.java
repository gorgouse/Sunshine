package com.xzsd.pc.client.dao;

import com.xzsd.pc.client.entity.ClientData;

import java.util.List;

public interface ClientDao {

    List<ClientData> clientListCheck(ClientData clientData);//列表查询
}
