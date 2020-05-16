package com.limbo.practice.core.util;


import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.Serializable;
import java.util.Locale;

/**
 * 消息获取工具
 *
 * @author : limbo
 * @date : 2020/5/11
 */
public class MessageUtils implements Serializable {

    // 消息资源管理
    public static final ReloadableResourceBundleMessageSource messageSource = SpringContextUtil.getBean("messageSource",
            ReloadableResourceBundleMessageSource.class);

    /**
     * 返回消息
     *
     * @param messageCode 消息编号
     * @param params 参数
     * @return
     */
    public static String getMessage(java.lang.String messageCode, java.lang.Object[] params){
        String message = messageSource.getMessage(messageCode, params, Locale.CHINA);
        return message;
    }

    /**
     * 返回消息
     *
     * @param messageCode 消息编号
     * @param params 参数
     * @param locale 语言
     * @return
     */
    public static String getMessage(java.lang.String messageCode, java.lang.Object[] params, Locale locale){
        String message = messageSource.getMessage(messageCode, params, locale);
        return message;
    }
}
