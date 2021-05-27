package com.limbo.practice.core.base;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 详情基础Service接口
 *
 * @param <T>
 * @author : limbo
 * @date : 2019/11/16
 */
public interface BaseService<T, D> {

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

    /**
     * 页面数据保存,局部更新
     *
     * @param vo 页面参数
     * @return
     */
    ResultBean saveActive(T vo);

    /**
     * 页面数据保存
     *
     * @param vo 页面参数
     * @return
     */
    int update(T vo);

    /**
     * 页面数据保存,局部更新
     *
     * @param vo 页面参数
     * @return
     */
    int updateActive(T vo);

    /**
     * 页面初始查询
     *
     * @param vo 页面参数
     * @return
     */
    PageTableBean queryList(T vo);

    /**
     * 获取数据
     *
     * @param vo 查询参数
     * @return
     */
    T get(T vo);

    /**
     * 通过ID获取数据
     *
     * @param id id
     * @return
     */
    T getById(Long id);

    /**
     * 插入数据
     *
     * @param bean
     * @return
     */
    Long insertDb(T bean);

    /**
     * 批量插入数据
     *
     * @param beanList
     * @return
     */
    int insertBatch(List<T> beanList);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    ResultBean delete(Long id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    ResultBean batchDelete(Long[] ids);
}
