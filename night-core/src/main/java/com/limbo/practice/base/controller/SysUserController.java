/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.controller;

import com.limbo.practice.base.dao.SysUserDao;
import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.base.entity.ro.SysUserRO;
import com.limbo.practice.base.service.SysUserService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.base.BaseController;
import com.limbo.practice.core.base.PageTableBean;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.controller
* @ClassName: SysUserController
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:12
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:12
*
* version V1.0
*/

@Api(tags = "系统用户管理")
@ApiResources(type = ResourceTypeEnum.MENU, roleName = RoleNameEnum.ADMIN, parent = MenuLevelEnum.SYS, order = 3)
@Controller
@RequestMapping("/sys-user")
public class SysUserController extends BaseController<SysUser, SysUserDao> {

    @Autowired
    private SysUserService<SysUser, SysUserDao> sysUserServiceImpl;

    @PostConstruct
    public void initService(){
        setService(sysUserServiceImpl);
    }

    @GetMapping("/view")
    @ApiOperation("显示页面")
    public ModelAndView view() {
        return new ModelAndView("/sys/user");
    }

    @GetMapping("/user-role")
    @ApiOperation("获取用户集合")
    @ResponseBody
    public PageTableBean queryList(SysUserRO ro) {
        return sysUserServiceImpl.pageUsers(ro);
    }
}
