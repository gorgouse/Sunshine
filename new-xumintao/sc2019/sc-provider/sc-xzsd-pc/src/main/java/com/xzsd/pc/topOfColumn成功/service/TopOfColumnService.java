package com.xzsd.pc.topOfColumn成功.service;

import com.xzsd.pc.topOfColumn成功.dao.TopOfColumnDao;
import com.xzsd.pc.topOfColumn成功.entity.TopOfColumnData;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TopOfColumnService {
    @Resource
    TopOfColumnDao topOfColumnDao;

    public AppResponse getTopOfColumn(TopOfColumnData topOfColumnData,String userId)
    {
        TopOfColumnData data = topOfColumnDao.getTopOfColumn(topOfColumnData,userId);
        return AppResponse.success("顶部栏查询成功",data);
    }

}
