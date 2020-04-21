package com.xzsd.pc.area成功.service;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.area成功.dao.AreaDao;
import com.xzsd.pc.area成功.entity.AreaInfo;
import com.xzsd.pc.area成功.entity.AreaList;
import com.xzsd.pc.area成功.entity.AreaVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AreaService {

    @Resource
    private AreaDao areaDao;


    public AppResponse getListArea(AreaInfo areaInfo){
        List<AreaVO> listArea = areaDao.getListArea(areaInfo);

        if(listArea.size() == 0){
            return AppResponse.bizError("查询失败！");
        }
        //这是为了封装成接口文档需要的名称
        AreaList areaList = new AreaList();
        areaList.setAreaList(listArea);
        return AppResponse.success("查询成功！", areaList);
    }
}
