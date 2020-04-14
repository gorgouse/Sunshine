package com.xzsd.pc.client.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.client.entity.ClientData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientService {
 @Resource
    private ClientDao clientDao;

    /**
     * 客户列表查询
     * @param clientData
     * @return
     */
    public AppResponse clientListCheck(ClientData clientData)
    {
        PageHelper.startPage(clientData.getPageNum(),clientData.getPageSize());
        List<ClientData> clientDataList = clientDao.clientListCheck(clientData);
        // 包装Page对象
        PageInfo<ClientData> pageData = new PageInfo<ClientData>(clientDataList);
        return AppResponse.success("查询成功！", pageData);

    }

}

