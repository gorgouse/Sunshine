package com.xzsd.pc.area成功.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.area成功.entity.AreaInfo;
import com.xzsd.pc.area成功.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/selectCombox")
public class AreaController {

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Resource
    private AreaService areaService;

    @PostMapping("listArea")
    public AppResponse getListArea(AreaInfo areaInfo){
        try {
            return areaService.getListArea(areaInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
