package com.limbo.practice.core.login.controller;

import com.alibaba.fastjson.JSON;
import com.limbo.practice.base.dao.SysUserDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.base.service.SysUserService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
import com.limbo.practice.core.login.domain.LoginUser;
import com.limbo.practice.core.shiro.token.manager.TokenManager;
import com.limbo.practice.core.util.LoggerUtils;
import com.limbo.practice.core.util.MessageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "系统登录")
@ApiResources(type = ResourceTypeEnum.RESOURCE, roleName = RoleNameEnum.NORMAL, parent = MenuLevelEnum.SYS)
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private SysUserService<SysUser, SysUserDao> sysUserService;

    /**
     * 访问登录页面
     * @param loginError
     * @return
     */
    @GetMapping("/login")
    @ApiOperation("请求登录页面")
    public ModelAndView login(String loginError){
        ModelAndView view = new ModelAndView("core/login");
        // 设置错误消息
        view.addObject(CoreConsts.LOGIN_ERROR_KEY, loginError);
        return view;
    }

    /**
     * 登录
     *
     * @param loginUser 登录用户信息
     * @param rememberMe 记住我
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("登录请求")
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
        return "redirect:/home";
    }

    /**
     * 显示首页
     *
     * @return
     */
    @GetMapping("/home")
    @ApiOperation("请求首页")
    public ModelAndView home(){
        // 初始化页面
        ModelAndView view = new ModelAndView("core/home");
        List<SysResource> menus = sysUserService.getMenuByUserId(TokenManager.getUserId());
        view.addObject("menus", JSON.toJSONString(menus));
        return view;
    }
}
