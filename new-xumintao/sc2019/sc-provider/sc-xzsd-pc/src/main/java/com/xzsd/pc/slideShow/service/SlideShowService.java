package com.xzsd.pc.slideShow.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.slideShow.controller.SlideShowController;
import com.xzsd.pc.slideShow.dao.SlideShowDao;
import com.xzsd.pc.slideShow.entity.SlideShowData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class SlideShowService {

    @Resource
    private SlideShowDao slideShowDao;

    private static final Logger logger = LoggerFactory.getLogger(SlideShowController.class);

    //新增
    @Transactional(rollbackFor = Exception.class)
    public AppResponse slideShowAdd(SlideShowData slideShowData)     //橙色代表这个方法与与Mapper的xuml文件对应
    {
        //检验ID是否存在
        int countSlideShowId = slideShowDao.countSlideShowId(slideShowData);             //比较ID不同
        if (0 != countSlideShowId)
        {
            return AppResponse.success("新增已存在，请再次尝试");
        }

        slideShowData.setSlideShowId(StringUtil.getCommonCode(2));  //生成随机编码ID
        slideShowData.setIsDelete(0);   //设置作废标记为0
        // 新增商品
        int count = slideShowDao.slideShowAdd(slideShowData);        //紫色字代表数据库的方法ID
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");


    }

    //分页查询

    public AppResponse slideShowListCheck(SlideShowData slideShowData) {
        PageHelper.startPage(slideShowData.getPageNum(), slideShowData.getPageSize());  //静态方法，传递两个参数（当前页码，每页查询条数）
        List<SlideShowData> slideShowDataList = slideShowDao.slideShowListCheck(slideShowData);
        // 包装Page对象
        PageInfo<SlideShowData> pageData = new PageInfo<SlideShowData>(slideShowDataList);          //返回的信息就是pageInfo对象，该类是插件里的类，
        return AppResponse.success("查询成功！", pageData);

    }

    /**
     * demo 删除商品
     *
     * @param slideShowId
     * @param userCode
     * @return
     * @Author sumintao
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse slideShowDelete(String slideShowId, String userCode) {
        List<String> listId = Arrays.asList(slideShowId.split(","));  //？
        // 删除
        int count = slideShowDao.slideShowDelete(listId, userCode);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }




    /**
     * demo 修改商品
     *
     * @param slideShowData
     * @return
     * @Author xumintao
     * @Date 2020-03-21
     */


    @Transactional(rollbackFor = Exception.class)
    public AppResponse slideShowUpdate(SlideShowData slideShowData) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countSlideShowId = slideShowDao.countSlideShowId(slideShowData);              //比较ID不同
        if (0 != countSlideShowId)
        {
            return AppResponse.success("新增的商品已存在，请再次尝试");
        }
        // 修改用户信息
        int count = slideShowDao.slideShowUpdate(slideShowData);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }





    //商品详情信息查询
    public AppResponse getSlideShowBySlideShowId(String goodsId)
    {

        SlideShowData slideShowData =  slideShowDao.getSlideShowBySlideShowId(goodsId);
        return AppResponse.success("查询成功！", slideShowData);




    }


}
