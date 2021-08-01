package com.limbo.practice.core.shiro.token.manager;

import com.limbo.practice.core.login.domain.LoginUser;
import com.limbo.practice.core.login.domain.LoginUserMemento;
import com.limbo.practice.core.shiro.token.LoginToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


/**
 * @author laif
 * @version 1.0,
 * @date 2019/4/9 17:31
 */
public class TokenManager {

    /**
     * 获取当前登录的用户User对象
     *
     * @return
     */
    public static LoginUser getToken() {
        LoginUser token = new LoginUser();
        LoginUserMemento tokenMemento = (LoginUserMemento) SecurityUtils.getSubject().getPrincipal();
        token.getFromMemento(tokenMemento);
        return token;
    }

    /**
     * 获取当前用户的Session
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取当前用户ID
     *
     * @return
     */
    public static Long getUserId() {
        return getToken() == null ? null : getToken().getId();
    }

    /**
     * 把值放入到当前登录用户的Session里
     *
     * @param key
     * @param value
     */
    public static void setVal2Session(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 从当前登录用户的Session里取值
     *
     * @param key
     * @return
     */
    public static Object getVal2Session(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 获取验证码，获取一次后删除
     *
     * @return
     */
    public static String getYZM() {
        String code = (String) getSession().getAttribute("CODE");
        getSession().removeAttribute("CODE");
        return code;
    }

    /**
     * 登录
     *
     * @param user
     * @param rememberMe
     * @return
     */
    public static LoginUser login(LoginUser user, Boolean rememberMe) {
        if (null == rememberMe) rememberMe = false;
        LoginToken token = new LoginToken(user, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        subject.isPermitted("admin:admin");
        return getToken();
    }

    /**
     * 判断是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        return null != SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 退出登录
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

}
