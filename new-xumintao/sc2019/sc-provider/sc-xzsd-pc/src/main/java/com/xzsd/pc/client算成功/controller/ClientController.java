package com.xzsd.pc.client算成功.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.client算成功.entity.ClientData;
import com.xzsd.pc.client算成功.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/client")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    @Resource

    private ClientService clientService;

    /**
     * 客户列表查询
     * @param clientData
     * @return
     */
    @RequestMapping(value = "clientListCheck")
    public AppResponse clientListCheck (ClientData clientData){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            clientData.setCreateBy(userId);
            return clientService.clientListCheck(clientData);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
