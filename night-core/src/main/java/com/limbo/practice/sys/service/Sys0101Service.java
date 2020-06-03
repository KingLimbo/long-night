package com.limbo.practice.sys.service;

import com.limbo.practice.core.login.domain.LoginUser;

/**
 * 登录服务Service
 *
 * @author limbo
 * @date 2019/4/25
 */
public interface Sys0101Service {

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    LoginUser getUserInfoByUserName(String username);

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @return
     */
    LoginUser getUserInfoByEmail(String email);

    /**
     * 根据电话号码查询用户
     *
     * @param phone
     * @return
     */
    LoginUser getUserInfoByPhone(String phone);

    /**
     * 根据登录信息（用户名、邮箱、电话号码）查询用户名称
     *
     * @param param
     * @return
     */
    LoginUser getUserInfoByLoginMessage(String param);

    /**
     * 根据主键更新用户登录信息
     *
     * @param loginUser
     */
    void updateByPrimaryKeySelective(LoginUser loginUser);
}
