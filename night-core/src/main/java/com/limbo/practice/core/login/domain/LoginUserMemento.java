package com.limbo.practice.core.login.domain;


import com.limbo.practice.core.base.BaseBO;
import lombok.Data;

import java.util.Date;
@Data
public class LoginUserMemento extends BaseBO {

    /**
     * 登录账户
     */
    private String loginAccount;
    /**
     * 登录密码
     */
    private String loginPass;
    /**
     * 登录盐
     */
    private String loginSalt;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户电话
     */
    private String userPhone;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 是否被锁
     */
    private Boolean locked;

    public LoginUserMemento(Long id, Boolean deleted, Date gmtCreate, Date gmtModified, String loginAccount,
                            String loginPass, String loginSalt, String userName, String userPhone, String userEmail, Boolean locked) {
        super(id, deleted, gmtCreate, gmtModified);
        this.loginAccount = loginAccount;
        this.loginPass = loginPass;
        this.loginSalt = loginSalt;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.locked = locked;
    }

}
