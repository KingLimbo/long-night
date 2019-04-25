package com.limbo.practice.core.login.service.impl;

import com.limbo.practice.core.login.dao.LoginDao;
import com.limbo.practice.core.login.domain.LoginUser;
import com.limbo.practice.core.login.service.LoginService;
import com.limbo.practice.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public LoginUser getUserInfoByUserName(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        LoginUser user = loginDao.selectUserInfoByUserName(username);
        return user;
    }

    @Override
    public LoginUser getUserInfoByEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        }
        LoginUser user = loginDao.selectUserInfoByEmail(email);
        return user;
    }

    @Override
    public LoginUser getUserInfoByPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        }
        LoginUser user = loginDao.selectUserInfoByPhone(phone);
        return user;
    }
}
