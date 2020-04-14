package com.xzsd.pc.classify.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.classify.entity.ClassifyData;
import com.xzsd.pc.classify.service.ClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/classify")
public class ClassifyController {

    private static final Logger logger = LoggerFactory.getLogger(ClassifyController.class);

    @Resource
    private ClassifyService classifyService;

    /**
     *  新增分类
     *
     * @param classifyData
     * @return AppResponse
     * @author xumintao
     * @Date 2020-03-21
     */
    @PostMapping("/classifyAdd")
    public AppResponse classifyAdd(ClassifyData classifyData)
    {
        try
        {
            String classifyId = AuthUtils.getCurrentUserId();
            classifyData.setCreateBy(classifyId);
            AppResponse appResponse = classifyService.classifyAdd(classifyData);  //对应dao的方法
            return appResponse;
        }catch (Exception e)
        {
            logger.error("分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 分类列表
     * @param
     * @return
     */
    @RequestMapping(value = "classifyListCheck")
    public AppResponse classifyListCheck() {
        try {
            return classifyService.classifyListCheck();
        } catch (Exception e) {
            logger.error("查询分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除分类
     * @param classifyData
     * @return
     */
    @PostMapping("classifyDelete")
    public AppResponse classifyDelete(ClassifyData classifyData) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            return classifyService.classifyDelete(classifyData);
        } catch (Exception e) {
            logger.error("分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改分类
     * @param classifyData
     * @return
     */
    @PostMapping("classifyUpdate")
    public AppResponse classifyUpdate(ClassifyData classifyData) {
        try {

            AppResponse appResponse = classifyService.classifyUpdate(classifyData);
            return appResponse;
        } catch (Exception e) {
            logger.error("修改分类信息错误", e);
            System.out.println(e.toString());

            throw e;
        }
    }

    /**
     * 分类详情
     * @param classifyId
     * @return
     */
    @RequestMapping(value = "getClassifyByClassifyId")
    public AppResponse getClassifyByClassifyId(String classifyId) {
        try {
            return classifyService.getClassifyByClassifyId(classifyId);
        } catch (Exception e) {
            logger.error("分类查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
