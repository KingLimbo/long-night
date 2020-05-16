package com.limbo.practice.base.entity;

import java.util.Date;

public class SysRoleUser extends SysRoleUserKey {
    private Boolean isDeleted;

    private Date gmtCreate;

    private Date gmtModified;

    public SysRoleUser(Long id, Long roleId, Long userId, Boolean isDeleted, Date gmtCreate, Date gmtModified) {
        super(id, roleId, userId);
        this.isDeleted = isDeleted;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public SysRoleUser() {
        super();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}