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

    /**
     * 轮播图新增
     * @param slideShowData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse slideShowAdd(SlideShowData slideShowData)
    {
        int countSlideShowId = slideShowDao.countSlideShowId(slideShowData);
        if (0 != countSlideShowId)
        {
            return AppResponse.success("轮播图已存在，请再次尝试");
        }
        slideShowData.setSlideShowId(StringUtil.getCommonCode(2));
        slideShowData.setIsDelete(0);
        // 新增商品
        int count = slideShowDao.slideShowAdd(slideShowData);
        if (0 == count) {
            return AppResponse.success("轮播图新增失败，请重试！");
        }
        return AppResponse.success("轮播图新增成功！");
    }

    /**
     * 轮播图分页查询
     * @param slideShowData
     * @return
     */
    public AppResponse slideShowListCheck(SlideShowData slideShowData) {
        PageHelper.startPage(slideShowData.getPageNum(), slideShowData.getPageSize());
        List<SlideShowData> slideShowDataList = slideShowDao.slideShowListCheck(slideShowData);

        PageInfo<SlideShowData> pageData = new PageInfo<SlideShowData>(slideShowDataList);
        return AppResponse.success("轮播图查询成功！", pageData);
    }

    /**
     * 轮播图删除
     * @param slideShowId
     * @param userCode
     * @return
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
     * 轮播图修改
     * @param slideShowData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse slideShowUpdate(SlideShowData slideShowData) {
        AppResponse appResponse = AppResponse.success("轮播图修改成功");
        // 校验账号是否存在
        int countSlideShowId = slideShowDao.countSlideShowId(slideShowData);
        if (0 != countSlideShowId)
        {
            return AppResponse.success("新增的轮播图已存在，请再次尝试");
        }
        int count = slideShowDao.slideShowUpdate(slideShowData);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 轮播图详情
     * @param goodsId
     * @return
     */
    public AppResponse getSlideShowBySlideShowId(String goodsId)
    {

        SlideShowData slideShowData =  slideShowDao.getSlideShowBySlideShowId(goodsId);
        return AppResponse.success("查询成功！", slideShowData);

    }
}
