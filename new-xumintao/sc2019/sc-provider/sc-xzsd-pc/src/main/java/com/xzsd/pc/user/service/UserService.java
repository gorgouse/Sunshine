package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public AppResponse userAdd(UserData userData) {
        //检验账号是否存在

        int countUserAccount = userDao.countUserAccount(userData);
        if (0 != countUserAccount) {
            return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
        }
        userData.setUserId(StringUtil.getCommonCode(2));
        userData.setIsDeleted(0);
        // 新增用户
        int count = userDao.userAdd(userData);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");

    }


        public AppResponse userListCheck(UserData userData)
        {
        PageHelper.startPage(userData.getPageNumber(), userData.getPageSize());
        List<UserData> userDataList = userDao.userListCheck(userData);
        // 包装Page对象
        PageInfo<UserData> pageData = new PageInfo<UserData>(userDataList);
        return AppResponse.success("查询成功！", pageData);

      }


        /**
         * demo 删除用户
         *
         * @param userCode
         * @param userId
         * @return
         * @Author xumintao
         * @Date 2020-03-21
         */
        @Transactional(rollbackFor = Exception.class)
        public AppResponse userDelete(String userId, String userCode) {  //删除的用户  操作的用户
        List<String> listId = Arrays.asList(userId.split(","));

        // 删除用户
        int count = userDao.userDelete(listId,userCode);
        if (0 == count) {
            return AppResponse.bizError("删除失败，难受！");
        }
        return AppResponse.success("删除成功！");
    }




        /**
         * user 修改用户
         *
         * @param userData
         * @return
         * @Author xumintao
         * @Date 2020-03-21
         */


        @Transactional(rollbackFor = Exception.class)
        public AppResponse userUpdate(UserData userData) {
            AppResponse appResponse = AppResponse.success("修改成功");
            // 校验账号是否存在
            int countUserAccount = userDao.countUserAccount(userData);
            if (0 != countUserAccount) {
                return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
            }
                // 修改用户信息
                int count = userDao.userUpdate(userData);
                if (0 == count) {
                    appResponse = AppResponse.versionError("数据有变化，请刷新！");
                    return appResponse;
                }
                return appResponse;
            }



    public AppResponse getUserByUserId(String userId) {
        UserData userdata = userDao.getUserByUserId(userId);
        return AppResponse.success("查询成功！", userdata);
    }






    }
