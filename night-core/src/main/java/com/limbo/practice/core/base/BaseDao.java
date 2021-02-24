package com.limbo.practice.core.base;

import java.util.List;

/**
 * 基础DAO
 *
 * @param <T>
 */
public interface BaseDao<T> {

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 根据bean获取数据
     *
     * @param bean
     * @return
     */
    T get(T bean);

    /**
     * 根据bean获取数据集合
     *
     * @param bean
     * @return
     */
    List<T> list(T bean);

    /**
     * 插入数据
     *
     * @param bean
     * @return
     */
    int insert(T bean);

    /**
     * 更新数据
     *
     * @param bean
     * @return
     */
    int update(T bean);

    /**
     * 更新数据,只更新设置的数据
     *
     * @param bean
     * @return
     */
    int updateActive(T bean);

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    int logicDelete(Long id);

    /**
     * 物理删除
     *
     * @param id
     * @return
     */
    int delete(Long id);
}
