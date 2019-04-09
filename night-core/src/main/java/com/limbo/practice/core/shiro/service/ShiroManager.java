package com.limbo.practice.core.shiro.service;

/**
 *
 *
 * @author laif
 * @version 1.0,
 * @date 2019/4/9 17:31
 *
 */
public interface ShiroManager {

	 /**
    * 加载过滤配置信息
    * @return
    */
   public String loadFilterChainDefinitions();
   
   /**
    * 重新构建权限过滤器
    * 一般在修改了用户角色、用户等信息时，需要再次调用该方法
    */
   public void reCreateFilterChains();
}
