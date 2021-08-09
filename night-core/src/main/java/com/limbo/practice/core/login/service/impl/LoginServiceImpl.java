package com.limbo.practice.core.login.service.impl;

import cn.hutool.core.util.StrUtil;
import com.limbo.practice.core.login.dao.LoginDao;
import com.limbo.practice.core.login.domain.LoginUser;
import com.limbo.practice.core.login.service.LoginService;
import com.limbo.practice.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 登录服务Service 实现类
 *
 * @author limbo
 * @date 2019/4/25
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    @Override
    public LoginUser getUserInfoByUserName(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        LoginUser user = loginDao.selectUserInfoByUserName(username);
        return user;
    }

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @return
     */
    @Override
    public LoginUser getUserInfoByEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        }
        LoginUser user = loginDao.selectUserInfoByEmail(email);
        return user;
    }

    /**
     * 根据电话号码查询用户
     *
     * @param phone
     * @return
     */
    @Override
    public LoginUser getUserInfoByPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        }
        LoginUser user = loginDao.selectUserInfoByPhone(phone);
        return user;
    }

    /**
     * 根据登录信息（用户名、邮箱、电话号码）查询用户名称
     *
     * @param param
     * @return
     */
    @Override
    public LoginUser getUserInfoByLoginMessage(String param) {
        if (StringUtils.isBlank(param)) {
            return null;
        }
        LoginUser user = loginDao.selectUserInfoByLoginMessage(param);
        return user;
    }

    /**
     * 根据登录id获取用户url权限
     * @param userId
     * @return
     */
    @Override
    public List<String> getUserUrlAuth(Long userId) {
        if (Objects.nonNull(userId)) {
            List<String> list = loginDao.selectUserUrlByUserId(userId);
            return list.stream().filter(s -> StrUtil.isNotBlank(s)).collect(Collectors.toList());
        }
        return null;
    }
}