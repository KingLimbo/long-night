package com.limbo.practice.core.login.domain;


import com.limbo.practice.core.base.BaseBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class LoginUser extends BaseBO {

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

    public LoginUser() {
    }

    public LoginUser(Long id, Boolean deleted, Date gmtCreate, Date gmtModified, String loginAccount, String loginPass, String loginSalt, String userName, String userPhone, String userEmail, Boolean locked) {
        super(id, deleted, gmtCreate, gmtModified);
        this.loginAccount = loginAccount;
        this.loginPass = loginPass;
        this.loginSalt = loginSalt;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.locked = locked;
    }

    /**
     * 保存到备忘录类
     *
     * @return 登录信息备忘录类
     */
    public LoginUserMemento saveToMemento(){
        return new LoginUserMemento(this.id, this.deleted, this.gmtCreate, this.gmtModified, this.loginAccount,
                this.loginPass, this.loginSalt, this.userName, this.userPhone, this.userEmail, this.locked);
    }

    /**
     * 从备忘录类中恢复
     *
     * @param memento 登录信息备忘录类
     */
    public void getFromMemento(LoginUserMemento memento){
        this.id = memento.getId();
        this.loginAccount = memento.getLoginAccount();
        this.loginPass = memento.getLoginPass();
        this.loginSalt = memento.getLoginSalt();
        this.userName = memento.getUserName();
        this.userPhone = memento.getUserPhone();
        this.userEmail = memento.getUserEmail();
        this.locked = memento.getLocked();
        this.gmtCreate = memento.getGmtCreate();
        this.gmtModified = memento.getGmtModified();
    }
}
