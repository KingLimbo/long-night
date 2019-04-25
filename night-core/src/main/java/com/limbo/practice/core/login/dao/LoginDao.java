package com.limbo.practice.core.login.dao;

import com.limbo.practice.core.login.domain.LoginUser;

/**
 * 登录DAO
 *
 * @author limbo
 * @date 2019/4/25
 */
public interface LoginDao {

    /**
     * 根据用户名查询用户名称
     *
     * @param username
     * @return
     */
    LoginUser selectUserInfoByUserName(String username);

    /**
     * 根据邮箱查询用户名称
     *
     * @param email
     * @return
     */
    LoginUser selectUserInfoByEmail(String email);

    /**
     * 根据电话号码查询用户名称
     *
     * @param phone
     * @return
     */
    LoginUser selectUserInfoByPhone(String phone);
}
