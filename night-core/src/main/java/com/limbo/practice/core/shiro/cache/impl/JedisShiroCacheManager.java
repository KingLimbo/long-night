package com.limbo.practice.core.shiro.cache.impl;

import com.limbo.practice.core.shiro.cache.JedisManager;
import com.limbo.practice.core.shiro.cache.JedisShiroCache;
import com.limbo.practice.core.shiro.cache.ShiroCacheManager;
import org.apache.shiro.cache.Cache;

/**
 * 
 * JRedis管理
 *
 * @author laif
 * @version 1.0
 * @version 1.0,2016年6月2日 <br/>
 * 
 */
public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
    	//如果和其他系统，或者应用在一起就不能关闭
    	//getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
