package com.xzsd.pc.user.dao;


import com.xzsd.pc.user.entity.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    int countUserAccount(UserData userData);


    int userAdd(UserData userData);


    List<UserData> userListCheck(UserData userData);//列表查询

    int userDelete(@Param("listId") List<String> listId, @Param("userCode") String userCode); //删除


    int userUpdate(UserData userData); //修改




    UserData getUserByUserId(@Param("userId") String userId); //注释




















}
