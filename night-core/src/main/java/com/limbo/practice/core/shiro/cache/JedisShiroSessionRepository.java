package com.limbo.practice.core.shiro.cache;

import com.limbo.practice.core.shiro.session.CustomSessionManager;
import com.limbo.practice.core.shiro.session.SessionStatus;
import com.limbo.practice.core.shiro.session.ShiroSessionRepository;
import com.limbo.practice.core.util.LoggerUtils;
import com.limbo.practice.core.util.SerializeUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.session.Session;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collection;

/**
 * Session 管理
 *
 * @author laif
 * @version 1.0,
 * @date 2019/4/9 17:31
 */
@SuppressWarnings("unchecked")
@Getter
@Setter
public class JedisShiroSessionRepository implements ShiroSessionRepository {
    public static final String REDIS_SHIRO_SESSION = "shiro-session:";
    // 这里有个小BUG，因为Redis使用序列化后，Key反序列化回来发现前面有一段乱码，解决的办法是存储缓存不序列化
    public static final String REDIS_SHIRO_ALL = "shiro-session:*";
    private static final int SESSION_VAL_TIME_SPAN = 18000;
    private static final int DB_INDEX = 1;

    private JedisManager jedisManager;
    private StringRedisSerializer keySerializer;

    @Override
    public void saveSession(Session session) {
        if (session == null || session.getId() == null)
            throw new NullPointerException("session is empty");
        try {
            byte[] key = rawKey(buildRedisSessionKey(session.getId()));

            // 不存在才添加。
            if (null == session.getAttribute(CustomSessionManager.SESSION_STATUS)) {
                // Session 踢出自存存储。
                SessionStatus sessionStatus = new SessionStatus();
                session.setAttribute(CustomSessionManager.SESSION_STATUS, sessionStatus);
            }

            byte[] value = SerializeUtil.serialize(session);
            long sessionTimeOut = session.getTimeout() / 1000;
            Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
            getJedisManager().saveValueByKey(DB_INDEX, key, value, expireTime.intValue());
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "save session error，id:[%s]", session.getId());
        }
    }

    @Override
    public void deleteSession(Serializable id) {
        if (id == null) {
            throw new NullPointerException("session id is empty");
        }
        try {
            getJedisManager().deleteByKey(DB_INDEX, rawKey(buildRedisSessionKey(id)));
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "删除session出现异常，id:[%s]", id);
        }
    }


    @Override
    public Session getSession(Serializable id) {
        if (id == null)
            throw new NullPointerException("session id is empty");
        Session session = null;
        try {
            byte[] value = getJedisManager().getValueByKey(DB_INDEX, rawKey(buildRedisSessionKey(id)));
            session = SerializeUtil.deserialize(value, Session.class);
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "获取session异常，id:[%s]", id);
        }
        return session;
    }

    @Override
    public Collection<Session> getAllSessions() {
        Collection<Session> sessions = null;
        try {
            sessions = getJedisManager().AllSession(DB_INDEX, REDIS_SHIRO_SESSION);
        } catch (Exception e) {
            LoggerUtils.fmtError(getClass(), e, "获取全部session异常");
        }

        return sessions;
    }

    private String buildRedisSessionKey(Serializable sessionId) {
        return REDIS_SHIRO_SESSION + sessionId;
    }

    private byte[] rawKey(String key) {
        Assert.notNull(key, "non null key required");
        if (keySerializer == null) {
            return SerializeUtil.serialize(key);
        }
        return keySerializer.serialize(key);
    }
}
