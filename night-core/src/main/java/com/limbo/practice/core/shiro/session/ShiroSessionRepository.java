package com.limbo.practice.core.shiro.session;

import org.apache.shiro.session.Session;

import java.io.Serializable;
import java.util.Collection;

/**
 * ShiroSession资源库接口
 *
 * @author laif
 * @version 1.0,
 * @date 2019/4/9 17:31
 */
public interface ShiroSessionRepository {

    /**
     * 存储Session
     *
     * @param session
     */
    void saveSession(Session session);

    /**
     * 删除session
     *
     * @param sessionId
     */
    void deleteSession(Serializable sessionId);

    /**
     * 获取session
     *
     * @param sessionId
     * @return
     */
    Session getSession(Serializable sessionId);

    /**
     * 获取所有sessoin
     *
     * @return
     */
    Collection<Session> getAllSessions();
}
