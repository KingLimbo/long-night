package com.limbo.practice.core.constant;

import java.util.Calendar;

/**
 * 核心常量类
 *
 * @author limbo
 * @version 2020-05-11
 */
public class CoreConsts {

    /**
     * 登录地址
     */
    public static final String LOGIN_URL = "redirect:/login";

    /**
     * 登录错误信息KEY
     */
    public static final String LOGIN_ERROR_KEY = "loginError";

    /**
     * 登录锁定_已锁定
     */
    public static final Boolean LOGIN_LOCKE_YES = true;

    /**
     * 登录锁定_未锁定
     */
    public static final Boolean LOGIN_LOCKE_NO = false;

    /**
     * SALT 固定盐
     */
    public static final String SALT_CONNECT = "night-core";

    /**
     * 项目根路径
     */
    public static final String CONTEXT_PATH = "ctx";


    /**
     * 输出标签Name
     */
    public static final String TARGET = "target";
    /**
     * 标签使用目标
     */
    public static final String OUT_TAG_NAME = "outTagName";

    /**
     * 其他常用变量
     **/
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String TOKEN = "token";
    public static final String LOING_USER = "loing_user";

    /**
     * Long
     */
    public static final Long ZERO = new Long(0);
    public static final Long ONE = new Long(1);
    public static final Long TWO = new Long(2);
    public static final Long THREE = new Long(3);
    public static final Long EIGHT = new Long(8);

    /**
     * String
     */
    public static final String S_ZERO = "0";
    public static final String S_ONE = "1";
    public static final String S_TOW = "2";
    public static final String S_THREE = "3";

    /**
     * Integer
     */
    public static final Integer I_ZERO = 0;
    public static final Integer I_ONE = 1;
    public static final Integer I_TOW = 2;
    public static final Integer I_THREE = 3;

    /**
     * cache常用变量
     **/
    public static final String CACHE_NAME = "shiro_cache";

    /**
     * cacheManager bean name
     */
    public static final String CACHE_MANAGER = "cacheManager";


    /**
     * 当前年份
     **/
    public static final int NOW_YEAR= Calendar.getInstance().get(Calendar.YEAR);
    /**
     * 处理状态 成功
     */
    public static final String SERVICE_SUCCESS = "success";

    /**
     * 核心包
     */
    public static final String CORE_PACKAGE = "com.limbo.practice";
    /**
     * 处理状态 失败
     */
    public static final String SERVICE_FAIL = "fail";
    /**
     * 反馈编号 正常
     */
    public static final Integer CODE_NORMAL = 200;
    /**
     * 反馈编号 错误
     */
    public static final Integer CODE_ERROR = 500;
    /**
     * 版本号，重启的时间
     */
    public static String VERSION = String.valueOf(System.currentTimeMillis());
}
