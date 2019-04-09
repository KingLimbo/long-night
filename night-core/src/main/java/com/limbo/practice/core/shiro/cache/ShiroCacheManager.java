package com.limbo.practice.core.shiro.cache;

import org.apache.shiro.cache.Cache;

 /**
 * shiro cache manager 接口
 *
 * @author laif
 * @version 1.0,
 * @date 2019/4/9 17:31
 *
 */
public interface ShiroCacheManager {

    <K, V> Cache<K, V> getCache(String name);

    void destroy();

}
