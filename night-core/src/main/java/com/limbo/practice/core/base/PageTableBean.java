package com.limbo.practice.core.base;

import java.util.List;

/**
 * PageTableBean 页面表格Bean
 *
 * @author limbo
 * @Date: 2019/11/12 13:55
 */
public class PageTableBean {

    private Integer code;

    // 数量
    private Long count;

    // 消息
    private String msg;

    // 数据集
    private List<?> data;

    public PageTableBean() {
        this.code = 0;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
