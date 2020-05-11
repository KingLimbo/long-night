package com.limbo.practice.core.login.domain;


import com.limbo.practice.core.base.BaseBO;

import java.util.Date;

public class LoginUserMemento extends BaseBO {

    // 登录账户
    private String loginAccount;
    // 登录密码
    private String loginPass;
    // 登录盐
    private String loginSalt;
    // 用户名
    private String userName;
    // 用户电话
    private String userPhone;
    // 用户邮箱
    private String userEmail;
    // 上次登录IP
    private String lastLoginIp;
    // 是否被锁
    private Boolean locked;
    //Session Id
    private String sessionId;
    // 访问地址IP
    private String host;
    // Session创建时间
    private Date startTime;
    // Session最后交互时间
    private Date lastAccess;
    // Session timeout时长
    private long timeout;

    public LoginUserMemento() {
    }

    public LoginUserMemento(Long id, Boolean deleted, Date gmtCreate, Date gmtModified, String loginAccount,
                            String loginPass, String loginSalt, String userName, String userPhone, String userEmail, String lastLoginIp, Boolean locked, String sessionId, String host, Date startTime, Date lastAccess, long timeout) {
        super(id, deleted, gmtCreate, gmtModified);
        this.loginAccount = loginAccount;
        this.loginPass = loginPass;
        this.loginSalt = loginSalt;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.lastLoginIp = lastLoginIp;
        this.locked = locked;
        this.sessionId = sessionId;
        this.host = host;
        this.startTime = startTime;
        this.lastAccess = lastAccess;
        this.timeout = timeout;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getLoginSalt() {
        return loginSalt;
    }

    public void setLoginSalt(String loginSalt) {
        this.loginSalt = loginSalt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
