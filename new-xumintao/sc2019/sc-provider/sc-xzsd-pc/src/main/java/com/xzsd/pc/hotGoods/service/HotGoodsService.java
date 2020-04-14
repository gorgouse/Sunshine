package com.xzsd.pc.hotGoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotGoods.controller.HotGoodsController;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.HotGoodsData;
import com.xzsd.pc.store.controller.StoreController;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    /**
     * 热门商品新增
     * @param hotGoodsData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse hotGoodsAdd(HotGoodsData hotGoodsData)
    {
        int countHotGoodsId = hotGoodsDao.countHotGoodsId(hotGoodsData);
        if (0 != countHotGoodsId)
        {
            return AppResponse.success("新增的热门商品已存在，请再次尝试");
        }

        hotGoodsData.setHotGoodsId(StringUtil.getCommonCode(2));
        hotGoodsData.setIsDelete(0);
        int count = hotGoodsDao.hotGoodsAdd(hotGoodsData);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 热门列表查询
     * @param hotGoodsData
     * @return
     */
    public AppResponse hotGoodsListCheck(HotGoodsData hotGoodsData) {
        PageHelper.startPage(hotGoodsData.getPageNum(), hotGoodsData.getPageSize());
        List<HotGoodsData> hotGoodsDataList = hotGoodsDao.hotGoodsListCheck(hotGoodsData);
        // 包装Page对象
        PageInfo<HotGoodsData> pageData = new PageInfo<HotGoodsData>(hotGoodsDataList);
        return AppResponse.success("查询成功！", pageData);
    }
    /**
     * 热门商品删除
     * @param hotGoodsId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse storeDelete(String hotGoodsId, String userId) {
        List<String> listId = Arrays.asList(hotGoodsId.split(","));  //？
        int count = hotGoodsDao.hotGoodsDelete(listId,userId);
        if (0 == count) {
            return AppResponse.bizError("删除热门失败，请重试！");
        }
        return AppResponse.success("删除成热门功！");
    }
    /**
     * 热门商品修改
     * @param hotGoodsData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse hotGoodsUpdate(HotGoodsData hotGoodsData) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int countHotGoodsId =hotGoodsDao.countHotGoodsId(hotGoodsData);
        if (0 != countHotGoodsId)
        {
            return AppResponse.success("修改的商品已存在，请再次尝试");
        }
        int count = hotGoodsDao.hotGoodsUpdate(hotGoodsData);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 热门详情
     * @param hotGoodsId
     * @return
     */
    public AppResponse getHotGoodsByHotGoodsId(String hotGoodsId)
    {

        HotGoodsData hotGoodsData = hotGoodsDao.getHotGoodsByHotGoodsId (hotGoodsId);
        return AppResponse.success("查询成功！", hotGoodsData);
    }
}
