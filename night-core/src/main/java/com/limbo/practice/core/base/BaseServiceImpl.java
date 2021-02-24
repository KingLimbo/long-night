package com.limbo.practice.core.base;

import org.springframework.web.servlet.ModelAndView;

/**
 * 基础service简单实现类
 *
 * @param <T>
 * @author : limbo
 * @date : 2019/11/16
 */
public abstract class BaseServiceImpl<D,T> implements BaseService<D,T> {

    /**
     * 页面初始化
     *
     * @param vo 页面参数
     * @return
     */
    public ModelAndView init(T vo) {
        return null;
    }

    /**
     * 页面数据保存
     *
     * @param vo 页面参数
     * @return
     */
    public ResultBean save(T vo) {
        return null;
    }

    /**
     * 删除
     *
     * @param vo 页面参数
     * @return
     */
    public ResultBean delete(T vo){
        return null;
    }

    /**
     * 页面初始查询
     *
     * @param vo 页面参数
     * @return
     */
    public PageTableBean queryList(T vo){
        return null;
    }
}
