package com.xzsd.pc.user.controller;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.user.entity.UserData;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查DEMO
 * @Author xumintao
 * @Date 2020-03-21
 */


@RestController
@RequestMapping("/user")

public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 新增用户
     * @param userData
     * @return
     */
    @PostMapping("/userAdd")
    public AppResponse userAdd(UserData userData) {
        try {
            String userID = AuthUtils.getCurrentUserId();
            userData.setCreateBy(userID);
            AppResponse appResponse = userService.userAdd(userData);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * 用户列表
     * @param userData
     * @return
     */
        @RequestMapping(value = "userListCheck")
        public AppResponse userListCheck (UserData userData){
            try {
                return userService.userListCheck(userData);
            } catch (Exception e) {
                logger.error("查询用户列表异常", e);
                System.out.println(e.toString());
                throw e;
            }
        }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @PostMapping("userDelete")
        public AppResponse userDelete (String userId){
            try {
                //获取用户id
                String userCode = AuthUtils.getCurrentUserId();
                return userService.userDelete(userId,userCode);
            } catch (Exception e) {
                logger.error("用户删除失败", e);
                System.out.println(e.toString());
                throw e;
            }
        }
    /**
     * 修改用户
     * @param userData
     * @return
     */
    @PostMapping("userUpdate")
        public AppResponse goodsUpdate(UserData userData) {
            try {
                //获取用户id
                String userId = AuthUtils.getCurrentUserId();
                userData.setCreateBy(userId);
                return userService.userUpdate(userData);
            } catch (Exception e) {
                logger.error("修改用户信息错误", e);
                System.out.println(e.toString());
                throw e;
            }

        }

    /**
     * 用户详情
     * @param userId
     * @return
     */
    @RequestMapping(value = "getUserByUserId")
            public AppResponse getUserByUserId(String userId) {
                try {
                    return userService.getUserByUserId(userId);
                } catch (Exception e) {
                    logger.error("用户查询错误", e);
                    System.out.println(e.toString());
                    throw e;
                }
            }

    }




























