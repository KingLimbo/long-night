package com.limbo.practice.core.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 基础类
 *
 * @author : limbo
 * @date : 2020/4/28
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BaseBO extends PageRO {

    /**
     * 设置序列化ID
     */
    protected static final long serialVersionUID = 1428L;

    /**
     * 主键ID
     */
    protected Long id;

    /**
     * 主键IDs
     */
    protected List<Long> ids;

    /**
     * 是否删除
     */
    protected Boolean deleted;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected Date gmtCreate;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected Date gmtModified;

    public BaseBO() {
    }

    public BaseBO(Long id, Boolean deleted, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.deleted = deleted;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }
}