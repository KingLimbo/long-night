package com.limbo.practice.core.login.controller;

import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.login.domain.LoginUser;
import com.limbo.practice.core.shiro.session.CustomSessionManager;
import com.limbo.practice.core.shiro.token.manager.TokenManager;
import com.limbo.practice.core.util.LoggerUtils;
import com.limbo.practice.core.util.MessageUtils;
import org.apache.shiro.authc.*;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){

        return new ModelAndView("/core/login");
    }

    /**
     * 登录
     *
     * @param loginUser 登录用户信息
     * @param rememberMe 记住我
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginUser loginUser, Boolean rememberMe, ModelMap modelMap, HttpServletRequest req){
        // 路径默认设置登录地址
        String loginPage = CoreConsts.LOGIN_URL;
        try {
            // 登录操作
            LoginUser user = TokenManager.login(loginUser, rememberMe);
        } catch (UnknownAccountException uae) {
            // "用户不存在"
            String errorMessage = MessageUtils.getMessage("LOGIN_USER_UNDEFINED", null);
            // 打印错误日志
            LoggerUtils.error(LoginController.class, errorMessage, uae);
            // 添加错误消息
            modelMap.addAttribute(CoreConsts.LOGIN_ERROR_KEY, errorMessage);
            return loginPage;
        } catch (IncorrectCredentialsException ice) {
            // 凭证不正确
            String errorMessage = MessageUtils.getMessage("LOGIN_TOKEN_ERROR", null);
            // 打印错误日志
            LoggerUtils.error(LoginController.class, errorMessage, ice);
            // 添加错误消息
            modelMap.addAttribute(CoreConsts.LOGIN_ERROR_KEY, errorMessage);
            return loginPage;
        } catch (LockedAccountException lae) {
            // 用户被锁
            String errorMessage = MessageUtils.getMessage("LOGIN_USER_LOCKED", null);
            // 打印错误日志
            LoggerUtils.error(LoginController.class, errorMessage, lae);
            // 添加错误消息
            modelMap.addAttribute(CoreConsts.LOGIN_ERROR_KEY, errorMessage);
            return loginPage;
        } catch (ExcessiveAttemptsException eae) {
            // 尝试过多
            String errorMessage = MessageUtils.getMessage("LOGIN_USER_CONNECT_MORE", null);
            // 打印错误日志
            LoggerUtils.error(LoginController.class, errorMessage, eae);
            // 添加错误消息
            modelMap.addAttribute(CoreConsts.LOGIN_ERROR_KEY, errorMessage);
            return loginPage;
        } catch (AuthenticationException ae) {
            // 认证失败
            String errorMessage = MessageUtils.getMessage("LOGIN_USER_PASSWORD_ERROR", null);
            // 打印错误日志
            LoggerUtils.error(LoginController.class, errorMessage, ae);
            // 添加错误消息
            modelMap.addAttribute(CoreConsts.LOGIN_ERROR_KEY, errorMessage);
            return loginPage;
        }
        // 获取工程路径
        String context = req.getContextPath();
        TokenManager.getSession().setAttribute(CoreConsts.CONTEXT_PATH, context);
        return "redirect:/index";
    }
}
