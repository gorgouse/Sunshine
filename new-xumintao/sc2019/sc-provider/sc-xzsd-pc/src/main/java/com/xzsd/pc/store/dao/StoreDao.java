package com.xzsd.pc.store.dao;
import com.xzsd.pc.store.entity.StoreData;
import com.xzsd.pc.user.entity.UserData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreDao {
    /**
     * 查询登录人的信息
     */
    UserData getUserByUserId(String userId);
    /**
     * 统计店长ID数量
     */
    int countStoreManagerId(StoreData storeData);
    /**
     * 校验营业执照编码
     */
    int countBussinessLicenseCode(StoreData storeData);
    /**
     * 统计邀请码数量
     * @param inviteCode
     * @return
     */
    int countInviteCode(String inviteCode);
    /**
     * 门店新增
     * @param storeData
     * @return
     */
    int  storeAdd(StoreData  storeData);
    /**
     * 门店列表查询
     * @param storeData
     * @return
     */
    List<StoreData>  storeListCheck(StoreData storeData);
    /**
     * 门店删除
     * @param listId
     * @param userId
     * @return
     */
    int  storeDelete(@Param("listId") List<String> listId, @Param("userId") String userId);
    /**
     * 门店修改
     * @param storeData
     * @return
     */
    int  storeUpdate(StoreData storeData);
    /**
     * 门店详情
     * @param storeId
     * @return
     */
    StoreData getStoreByStoreId(@Param("storeId") String storeId);
    /**
     * 查询省列表
     */
    List<StoreData>listProvince();
    /**
     * 查询市列表
     */
    List<StoreData>listCity(String provinceCode);
    /**
     * 查询区列表
     */
    List<StoreData>listArea(String cityCode);
}
