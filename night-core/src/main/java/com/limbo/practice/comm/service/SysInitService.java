package com.limbo.practice.comm.service;

/**
 * 系统初始化service
 *
 * @author limbo
 * @version 2021/3/5
 */
public interface SysInitService {

    /**
     * 初始角色
     */
    void initRole();

    /**
     * 初始化菜单级别
     */
    void initMenuLevel();
}
