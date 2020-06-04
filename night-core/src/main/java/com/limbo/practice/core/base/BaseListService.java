package com.limbo.practice.core.base;

import org.springframework.web.servlet.ModelAndView;

/**
 * 基础清单Service接口
 *
 * @author : limbo
 * @date : 2020/6/4
 */
public interface BaseListService<T> {

    /**
     * 页面初始化
     *
     * @param vo 页面参数
     * @return
     */
    ModelAndView init(T vo);

    /**
     * 页面初始查询
     *
     * @param vo 页面参数
     * @return
     */
    PageTableBean queryList(T vo);

    /**
     * 删除
     *
     * @param vo 页面参数
     * @return
     */
    PageTableBean delete(T vo);
}
