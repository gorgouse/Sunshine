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

    /**
     * 新增用户
     * @param userData
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse userAdd(UserData userData) {
        int countUserAccount = userDao.countUserAccount(userData);
        if (0 != countUserAccount) {
            return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
        }
        userData.setUserId(StringUtil.getCommonCode(2));
        userData.setIsDeleted(0);
        int count = userDao.userAdd(userData);
        if (0 == count) {
            return AppResponse.success("新增用户失败，请重试！");
        }
        return AppResponse.success("新增用户成功！");
    }

    /**
     * 用户列表查询
     * @param userData
     * @return
     */
        public AppResponse userListCheck(UserData userData)
        {
        PageHelper.startPage(userData.getPageNumber(), userData.getPageSize());
        List<UserData> userDataList = userDao.userListCheck(userData);
        PageInfo<UserData> pageData = new PageInfo<UserData>(userDataList);
        return AppResponse.success("查询用户成功！", pageData);
      }

    /**
     * 删除用户
     * @param userId
     * @param userCode
     * @return
     */
        @Transactional(rollbackFor = Exception.class)
        public AppResponse userDelete(String userId, String userCode) {
        List<String> listId = Arrays.asList(userId.split(","));
        int count = userDao.userDelete(listId,userCode);
        if (0 == count) {
            return AppResponse.bizError("用户删除失败，难受！");
        }
        return AppResponse.success("用户删除成功！");
    }

    /**
     * 用户修改
     * @param userData
     * @return
     */
        @Transactional(rollbackFor = Exception.class)
        public AppResponse userUpdate(UserData userData) {
            AppResponse appResponse = AppResponse.success("修改成功");
            int countUserAccount = userDao.countUserAccount(userData);
            if (0 != countUserAccount) {
                return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
            }
                int count = userDao.userUpdate(userData);
                if (0 == count) {
                    appResponse = AppResponse.versionError("数据有变化，请刷新！");
                    return appResponse;
                }
                return appResponse;
            }

    /**
     * 用户详情
     * @param userId
     * @return
     */
    public AppResponse getUserByUserId(String userId) {
        UserData userdata = userDao.getUserByUserId(userId);
        return AppResponse.success("查询成功！", userdata);
    }






    }
