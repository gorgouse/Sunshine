package com.xzsd.pc.user成功.dao;


import com.xzsd.pc.user成功.entity.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 获取登录者角色
     * @param currentUserId
     * @return
     */
    String getUserRole(@Param("currentUserId") String currentUserId);
    /**
     * 统计用户账号的ID
     * @param userData
     * @return
     */
    int countUserAccount(UserData userData);
    /**
     * 统计手机号
     */
    int countPhone(UserData userData);
    /**
     * 增加用户
     * @param userData
     * @return
     */
    int userAdd(UserData userData);

    /**
     * 用户列表查询
     * @param userData
     * @return
     */
    List<UserData> userListCheck(UserData userData);//列表查询

    /**
     * 用户删除
     * @param listId
     * @param currentUserId
     * @return
     */
    int userDelete(@Param("listId") List<String> listId, @Param("currentUserId") String currentUserId); //删除

    /**
     * 用户更改
     * @param userData
     * @return
     */
    int userUpdate(UserData userData);
    /**
     * 用户详情
     * @param userId
     * @return
     */
    UserData getUserByUserId(@Param("userId") String userId);




















}
