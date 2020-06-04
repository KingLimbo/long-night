package com.limbo.practice.core.base;

import org.springframework.web.servlet.ModelAndView;

/**
 * 详情基础Service接口
 *
 * @param <T>
 * @author : limbo
 * @date : 2019/11/16
 */
public interface BaseDetailService<T> {

    /**
     * 页面初始化
     *
     * @param vo 页面参数
     * @return
     */
    ModelAndView init(T vo);

    /**
     * 页面数据保存
     *
     * @param vo 页面参数
     * @return
     */
    ResultBean save(T vo);
}
