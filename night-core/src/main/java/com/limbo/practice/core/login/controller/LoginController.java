package com.limbo.practice.core.login.controller;

import com.limbo.practice.core.login.domain.LoginUser;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){

        return new ModelAndView("/core/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginUser loginUser){
        return "/index";
    }
}
