package com.limbo.practice.sys.domain;


import com.limbo.practice.core.base.BaseBO;
import com.limbo.practice.core.login.domain.LoginUserMemento;

import java.util.Date;

public class Sys0101VO extends BaseBO {

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

    public Sys0101VO() {
    }

    public Sys0101VO(Long id, Boolean deleted, Date gmtCreate, Date gmtModified, String loginAccount,
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

    /**
     * 保存到备忘录类
     *
     * @return 登录信息备忘录类
     */
    public LoginUserMemento saveToMemento(){
        return new LoginUserMemento(this.id, this.deleted, this.gmtCreate, this.gmtModified, this.loginAccount,
                this.loginPass, this.loginSalt, this.userName, this.userPhone, this.userEmail, this.lastLoginIp, this.locked, this.sessionId, this.host, this.startTime, this.lastAccess, this.timeout);
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
        this.lastLoginIp = memento.getLastLoginIp();
        this.locked = memento.getLocked();
        this.sessionId = memento.getSessionId();
        this.host = memento.getHost();
        this.startTime = memento.getStartTime();
        this.lastAccess = memento.getLastAccess();
        this.timeout = memento.getTimeout();
        this.gmtCreate = memento.getGmtCreate();
        this.gmtModified = memento.getGmtModified();
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
