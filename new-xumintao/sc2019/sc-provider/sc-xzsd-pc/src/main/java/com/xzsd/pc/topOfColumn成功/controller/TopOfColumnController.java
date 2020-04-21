package com.xzsd.pc.topOfColumn成功.controller;

import com.xzsd.pc.topOfColumn成功.entity.TopOfColumnData;
import com.xzsd.pc.topOfColumn成功.service.TopOfColumnService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("topOfColumn")
public class TopOfColumnController {
    @Resource
    private TopOfColumnService topOfColumnService;
    private static final Logger logger = LoggerFactory.getLogger(TopOfColumnController.class);
    /**
     * 获取顶部栏数据
     */
    @PostMapping("getTopOfColumn")
    public AppResponse getTopOfColumn(TopOfColumnData topOfColumnData)
    {
        try {
            String userCode = AuthUtils.getCurrentUserId();
            return  topOfColumnService.getTopOfColumn(topOfColumnData,userCode);
        } catch (Exception e) {
            logger.error("顶部栏查询异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
