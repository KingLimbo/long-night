package com.limbo.practice.core.shiro.filter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.limbo.practice.core.constant.RedisKey;
import com.limbo.practice.core.login.domain.LoginUserMemento;
import com.limbo.practice.core.shiro.token.manager.TokenManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lf
 * @date 2021-06-23
 */
@Slf4j
public class MyAuthenticationFilter extends FormAuthenticationFilter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //如果请求的是loginUrl 并且是POST请求，那么肯定是要验证密码的，这里直接返回false 就会执行onAcessDenied()方法
        String requestUrl = getPathWithinApplication(request);
        log.debug("请求地址：", requestUrl);
        if (isLoginRequest(request, response) && isLoginSubmission(request, response)) {
            return false;
        }
        if (StrUtil.equals(requestUrl, "/home")) {
            //如果是其他请求 则执行父类的方法
            return super.isAccessAllowed(request, response, mappedValue);
        }
        Subject subject = getSubject(request, response);
        LoginUserMemento primaryPrincipal = (LoginUserMemento) subject.getPrincipal();
        if (Objects.isNull(primaryPrincipal)) {
            return false;
        }
        Object result = TokenManager.getVal2Session(RedisKey.USER_URL_AUTH);
        if (Objects.nonNull(request)) {
            List<String> userUrlAuth = JSONObject.parseArray(result.toString(), String.class);
            AtomicBoolean allow = new AtomicBoolean(false);
            userUrlAuth.forEach(o -> {
                boolean match = pathsMatch(o, requestUrl);
                if (match) {
                    allow.set(true);
                    return;
                }
            });
            System.out.println(userUrlAuth.contains(requestUrl));
            return allow.get();
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }
            if (isAjax(request)) {
                // 设置缓存区编码为UTF-8编码格式
                response.setCharacterEncoding("UTF-8");
                // 可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
                response.setContentType("application/json;charset=utf-8");
                Map<String,String> resultMap = new HashMap<String, String>();
                resultMap.put("login_status", "300");
                resultMap.put("message", "403权限错误");
                outJson(response, resultMap);
            } else {
                if (isNotLogin(request, response)) {
                    saveRequestAndRedirectToLogin(request, response);
                } else {
                    WebUtils.issueRedirect(request, response, "/404");
                }
            }

            return false;
        }
    }

    /**
     * 判断没有登录用户
     *
     * @param request
     * @param response
     * @return
     */
    private boolean isNotLogin(ServletRequest request, ServletResponse response) {
        Subject subject = getSubject(request, response);
        LoginUserMemento primaryPrincipal = (LoginUserMemento) subject.getPrincipal();
        if (Objects.isNull(primaryPrincipal)) {
            return true;
        }
        return false;
    }

    /**
     * 是否是Ajax请求
     *
     * @param request
     * @return
     */
    private boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    /**
     * response 输出JSON
     *
     * @param response
     * @param resultMap
     * @throws IOException
     */
    private void outJson(ServletResponse response, Map<String, String> resultMap){

        PrintWriter out = null;
        try {
            // 设置缓存区编码为UTF-8编码格式
            response.setCharacterEncoding("UTF-8");
            // 可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.println(JSONObject.toJSONString(resultMap));
        } catch (Exception e) {
            log.debug("输出JSON报错：", e);
        }finally{
            if(null != out){
                out.flush();
                out.close();
            }
        }
    }
}