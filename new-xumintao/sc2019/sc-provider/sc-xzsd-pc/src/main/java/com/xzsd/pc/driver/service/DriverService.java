package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse driverAdd(DriverData driverData) {
        //检验账号是否存在

        int countDriverAccount = driverDao.countDriverAccount(driverData);;
        if (0 != countDriverAccount) {
            return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
        }
        driverData.setDriverId(StringUtil.getCommonCode(2));
        driverData.setIsDelete(0);
        // 新增用户
        int count = driverDao.driverAdd(driverData);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");

    }


    public AppResponse driverListCheck(DriverData driverData)
    {
        PageHelper.startPage(driverData.getPageNum(),driverData.getPageSize());
        List<DriverData> driverDataList = driverDao.driverListCheck(driverData);
        // 包装Page对象
        PageInfo<DriverData> pageData = new PageInfo<DriverData>(driverDataList);
        return AppResponse.success("查询成功！", pageData);

    }


    /**
     * demo 删除用户
     *
     * @param userCode
     * @param driverId
     * @return
     * @Author xumintao
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse driverDelete(String driverId, String userCode) {  //删除的用户  操作的用户
        List<String> listId = Arrays.asList(driverId.split(","));

        // 删除用户
        int count = driverDao.driverDelete(listId,userCode);
        if (0 == count) {
            return AppResponse.bizError("删除失败，难受！");
        }
        return AppResponse.success("删除成功！");
    }




    /**
     * user 修改用户
     *
     * @param driverData
     * @return
     * @Author xumintao
     * @Date 2020-03-21
     */


    @Transactional(rollbackFor = Exception.class)
    public AppResponse driverUpdate(DriverData driverData) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAccount = driverDao.countDriverAccount(driverData);
        if (0 != countUserAccount) {
            return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
        }
        // 修改用户信息
        int count = driverDao.driverUpdate(driverData);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }



    public AppResponse getDriverByDriverId(String driverId) {
        DriverData driverData = driverDao.getDriverByDriverId(driverId);
        return AppResponse.success("查询成功！", driverData);
    }

}
