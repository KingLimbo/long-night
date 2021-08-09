/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.controller;

import com.limbo.practice.base.dao.SysRoleDao;
import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.base.service.SysRoleService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.base.BaseController;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.controller
* @ClassName: SysRoleController
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:10
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:10
*
* version V1.0
*/

@Api(tags = "系统角色管理")
@ApiResources(type = ResourceTypeEnum.MENU, roleName = RoleNameEnum.ADMIN, parent = MenuLevelEnum.SYS, order = 2)
@Controller
@RequestMapping("/sys-role")
public class SysRoleController extends BaseController<SysRole, SysRoleDao> {

    @Autowired
    private SysRoleService<SysRole, SysRoleDao> sysRoleServiceImpl;

    @PostConstruct
    public void initService(){
        setService(sysRoleServiceImpl);
    }

    @GetMapping("/view")
    @ApiOperation("显示页面")
    public ModelAndView view() {
        return new ModelAndView("/sys/role");
    }

}
