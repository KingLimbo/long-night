package com.limbo.practice.core.shiro.token;

import com.limbo.practice.core.login.domain.LoginUser;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 登录Token
 *
 * @author limbo
 * @date 2019/4/25
 */
public class LoginToken extends UsernamePasswordToken  implements java.io.Serializable{

    private static final long serialVersionUID = -6451794657814516574L;

    /**
     * 邮箱
     */
    private java.lang.String email;

    /**
     * 手机号码
     */
    private java.lang.String phone;

    /**
     * 构造方法
     *
     * @param user 登录用户
     * @param rememberMe 记住我标识
     */
    public LoginToken(LoginUser user, boolean rememberMe){
        super(user.getUserName(), user.getLoginPass(), rememberMe, "");
        this.email = user.getUserEmail();
        this.phone = user.getUserPhone();
    }
    /**
     * 构造方法
     *
     * @param username 用户名
     * @param password 密码
     * @param rememberMe 记住我标识
     * @param host ip地址
     */
    public LoginToken(java.lang.String username, java.lang.String password, boolean rememberMe,
               java.lang.String host,String email,String phone){
        super(username, password, rememberMe, host);
        this.email = email;
        this.phone = phone;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPhone() {
        return phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }
}
