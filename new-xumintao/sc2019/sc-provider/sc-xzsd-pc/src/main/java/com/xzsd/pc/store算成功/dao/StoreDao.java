package com.xzsd.pc.store算成功.dao;
import com.xzsd.pc.store算成功.entity.StoreData;
import com.xzsd.pc.user成功.entity.UserData;
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
    int  storeAdd(StoreData storeData);

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
     * 管理员查询所有门店信息
     * @param storeData
     * @return
     */
    List<StoreData> getListStoreByAdmin(StoreData storeData);
    /**
     * 店长查询自己门店信息
     * @param storeData
     * @return
     */
    List<StoreData> getListStore(StoreData storeData);
}
