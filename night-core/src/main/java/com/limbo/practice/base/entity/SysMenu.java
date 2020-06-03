package com.limbo.practice.base.entity;

import java.util.Date;

public class SysMenu {
    private Long id;

    private String menuName;

    private String menuUrl;

    private Boolean menuType;

    private Byte menuSort;

    private String menuDescription;

    private Boolean isDeleted;

    private Date gmtCreate;

    private Date gmtModified;

    public SysMenu(Long id, String menuName, String menuUrl, Boolean menuType, Byte menuSort, String menuDescription, Boolean isDeleted, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.menuType = menuType;
        this.menuSort = menuSort;
        this.menuDescription = menuDescription;
        this.isDeleted = isDeleted;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public SysMenu() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Boolean getMenuType() {
        return menuType;
    }

    public void setMenuType(Boolean menuType) {
        this.menuType = menuType;
    }

    public Byte getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Byte menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription == null ? null : menuDescription.trim();
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