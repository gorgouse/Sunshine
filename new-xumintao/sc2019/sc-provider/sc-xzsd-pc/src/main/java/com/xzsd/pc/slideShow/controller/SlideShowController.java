package com.xzsd.pc.slideShow.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.slideShow.entity.SlideShowData;
import com.xzsd.pc.slideShow.service.SlideShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController //如果控制器产生的结果不需要让人看到，那么它产生的数据经过消息转换器直接返回到浏览器
@RequestMapping("/slideShow")
public class SlideShowController {

    private static final Logger logger = LoggerFactory.getLogger(SlideShowController.class);  //

    @Resource
    private SlideShowService slideShowService;

    /**
     * 轮播图新增
     * @param slideShowData
     * @return
     */
    @PostMapping("/slideShowAdd")
    public AppResponse slideShowAdd(SlideShowData slideShowData) {
        try {
            String slideShowId = AuthUtils.getCurrentUserId();
            slideShowData.setCreateBy(slideShowId);
            AppResponse appResponse = slideShowService.slideShowAdd(slideShowData);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图列表
     * @param slideShowData
     * @return
     */
    @RequestMapping(value = "slideShowListCheck")
    public AppResponse slideShowListCheck(SlideShowData slideShowData) {
        try {
            return slideShowService.slideShowListCheck(slideShowData);
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图删除
     * @param slideShowId
     * @return
     */
    @PostMapping("slideShowDelete")
    public AppResponse slideShowDelete(String slideShowId) {
        try {
            //获取用户id
            String userCode = AuthUtils.getCurrentUserId();
            return slideShowService.slideShowDelete(slideShowId,userCode);
        } catch (Exception e) {
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 轮播图修改
     * @param slideShowData
     * @return
     */
    @PostMapping("slideShowUpdate")
    public AppResponse slideShowUpdate(SlideShowData slideShowData) {
        try {
            //获取用户id
            String slideShowId = AuthUtils.getCurrentUserId();
            slideShowData.setCreateBy(slideShowId);
            slideShowData.setCreateBy(slideShowId);
            return slideShowService.slideShowUpdate(slideShowData);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }















    /**
     * goods 商品详情查询
     *
     * @param  slideShowId           //paramtric参数
     * @return AppResponse         //@requestmapping地址映射
     * @author xumintao
     * @Date 2020-03-21
     */
    @RequestMapping(value = "getSlideShowBySlideShowId")
    public AppResponse getSlideShowBySlideShowId(String slideShowId) {
        try {
            return slideShowService.getSlideShowBySlideShowId(slideShowId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }









}
