package com.xzsd.pc.area成功.dao;


import com.xzsd.pc.area成功.entity.AreaInfo;
import com.xzsd.pc.area成功.entity.AreaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AreaDao {


    List<AreaVO> getListArea(AreaInfo areaInfo);
}
