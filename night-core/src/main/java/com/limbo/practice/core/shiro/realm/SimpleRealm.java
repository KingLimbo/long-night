package com.limbo.practice.core.shiro.realm;

import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.constant.RedisKey;
import com.limbo.practice.core.login.domain.LoginUser;
import com.limbo.practice.core.login.domain.LoginUserMemento;
import com.limbo.practice.core.login.service.LoginService;
import com.limbo.practice.core.shiro.token.LoginToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * 简单的Realm
 *
 * @author limbo
 * @date 2019/4/25
 */
public class SimpleRealm extends AuthorizingRealm {

    /**
     * 登录处理service
     */
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LoginUserMemento primaryPrincipal = (LoginUserMemento) principalCollection.getPrimaryPrincipal();
        Long userId = primaryPrincipal.getId();
        List<String> userUrlAuth = loginService.getUserUrlAuth(userId);
        redisTemplate.opsForList().leftPushAll(RedisKey.USER_URL_AUTH + userId, userUrlAuth);
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LoginToken loginToken = (LoginToken) authenticationToken;
        // 取出登录用户
        LoginUser user = loginService.getUserInfoByLoginMessage(loginToken.getUsername());
        if (null == user) {
            throw new UnknownAccountException("帐号不存在！");
        // 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
        } else if (CoreConsts.LOGIN_LOCKE_YES.equals(user.getLocked())) {
            throw new LockedAccountException("帐号已经禁止登录！");
        } else {
            // 更新登录时间 last login time
//            user.setLastLoginTime(new Date());
            // 更新登录ip地址 last login ip
//            user.setLastLoginIp(loginToken.getHost());
//            loginService.updateByPrimaryKeySelective(user);
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.saveToMemento(),
                user.getLoginPass(),
                ByteSource.Util.bytes(user.getLoginAccount() + CoreConsts.SALT_CONNECT + user.getLoginSalt()),
                getName());
        return authenticationInfo;
    }
}
