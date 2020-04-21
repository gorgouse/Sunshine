package com.xzsd.pc.client算成功.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.client算成功.dao.ClientDao;
import com.xzsd.pc.client算成功.entity.ClientData;
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
        List<ClientData> listCustomers = null;
        PageHelper.startPage(clientData.getPageNum(),clientData.getPageSize());
        //0为管理员查询所有客户,2为店长查询本店客户
        if("2".equals(clientData.getRole()))
        {
            listCustomers = clientDao.getListCustomers(clientData);
        }

        else if("0".equals(clientData.getRole())||"1".equals(clientData.getRole()))
        {
            listCustomers = clientDao.getListCustomersByAdmin(clientData);
        }
        PageInfo<ClientData> pageData = new PageInfo<ClientData>(listCustomers);
        return AppResponse.success("查询成功！", pageData);

    }

}

