package com.xzsd.pc.user成功.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user成功.dao.UserDao;
import com.xzsd.pc.user成功.entity.UserData;
import com.xzsd.pc.util.PasswordUtils;
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
        //密码加密
        String userPassword = PasswordUtils.generatePassword(userData.getUserPassword());
        userData.setUserPassword(userPassword);
        //校验用户账号是否已经存在
        int countUserAccount = userDao.countUserAccount(userData);
        if (0 != countUserAccount) {
            return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
        }
        //校验是否存在相同的手机号
        int countPhone = userDao.countPhone(userData);
        if(0 != countPhone){
            return AppResponse.versionError("该手机号已经存在，请重新输入");
        }
        //设置获取写死ID
        userData.setUserId(StringUtil.getCommonCode(2));
        userData.setIsDelete(0);

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
     * @param currentUserId
     * @return
     */
        @Transactional(rollbackFor = Exception.class)
        public AppResponse userDelete(String userId, String currentUserId) {
        List<String> listId = Arrays.asList(userId.split(","));
        int count = userDao.userDelete(listId,currentUserId);
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
            int countUserAccount = userDao.countUserAccount(userData);
            if (0 != countUserAccount)
            {
                return AppResponse.success("亲，用户账号已存在哦，请再输一遍吧");
            }

            int count = userDao.userUpdate(userData);
            if (0 == count)
            {
                    return AppResponse.versionError("修改失败");

            }
                return AppResponse.success("修改成功");
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
