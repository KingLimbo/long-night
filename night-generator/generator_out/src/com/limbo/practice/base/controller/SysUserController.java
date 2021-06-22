/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.limbo.practice.core.base.BaseController;
import com.limbo.practice.base.dao.SysUserDao;
import com.limbo.practice.base.entity.SysUser;
import javax.annotation.PostConstruct;
import $
import javax.annotation.PostConstruct;{basepackage}.base.service.SysUserService;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.controller
* @ClassName: SysUserController
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-05-26 10:08:21
* @Modifier: limbo
* @ModifiedDate: 2021-05-26 10:08:21
*
* version V1.0
*/

@Controller
public class SysUserController extends BaseController<SysUser, SysUserDao> {

    @Autowired
    private SysUserService<SysUser, SysUserDao>  sysUserServiceImpl;

    @PostConstruct
    public void initService(){
        setService(sysResourceServiceImpl);
    }
}
