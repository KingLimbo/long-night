package com.limbo.practice.core.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础类
 *
 * @author : limbo
 * @date : 2020/4/28
 */
public class BaseBO implements Serializable {

    /**
     * 设置序列化ID
     */
    protected static final long serialVersionUID = 1428L;
    /**
     * 主键ID
     */
    protected Long id;
    /**
     * 是否删除
     */
    protected Boolean deleted;
    /**
     * 创建时间
     */
    protected Date gmtCreate;
    /**
     * 创建者
     */
    protected Date gmtModified;

    public BaseBO() {
    }

    public BaseBO(Long id, Boolean deleted, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.deleted = deleted;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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
