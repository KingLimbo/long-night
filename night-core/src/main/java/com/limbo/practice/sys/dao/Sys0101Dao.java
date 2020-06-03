package com.limbo.practice.sys.dao;

import com.limbo.practice.core.login.domain.LoginUser;
import com.limbo.practice.core.mybatis.MybatisDao;

/**
 * Sys0101Dao
 *
 * @author limbo
 * @date 2019/4/25
 */
@MybatisDao
public interface Sys0101Dao {

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

    /**
     * 根据登录信息（用户名、邮箱、电话号码）查询用户
     *
     * @param param
     * @return
     */
    LoginUser selectUserInfoByLoginMessage(String param);

    /**
     * 根据主键更新用户登录信息
     *
     * @param loginUser
     */
    int updateByPrimaryKeySelective(LoginUser loginUser);
}
