package com.limbo.practice.base.entity;

import java.util.Date;

public class SysPermission {
    private Long id;

    private String permissionName;

    private String permissionDescription;

    private String permissionUrl;

    private Boolean permissionType;

    private Boolean isDeleted;

    private Date gmtCreate;

    private Date gmtModified;

    public SysPermission(Long id, String permissionName, String permissionDescription, String permissionUrl, Boolean permissionType, Boolean isDeleted, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
        this.permissionUrl = permissionUrl;
        this.permissionType = permissionType;
        this.isDeleted = isDeleted;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public SysPermission() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription == null ? null : permissionDescription.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public Boolean getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Boolean permissionType) {
        this.permissionType = permissionType;
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