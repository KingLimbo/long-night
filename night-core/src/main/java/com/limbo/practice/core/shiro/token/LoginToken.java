package com.limbo.practice.core.shiro.token;

import com.limbo.practice.core.login.domain.LoginUser;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 登录Token
 *
 * @author limbo
 * @date 2019/4/25
 */
@Setter
@Getter
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
        super(user.getLoginAccount(), user.getLoginPass(), rememberMe);
        this.email = user.getUserEmail();
        this.phone = user.getUserPhone();
    }

}
