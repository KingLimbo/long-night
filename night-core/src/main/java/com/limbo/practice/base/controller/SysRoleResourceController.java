/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.controller;

import com.limbo.practice.base.dao.SysRoleResourceDao;
import com.limbo.practice.base.entity.SysRoleResource;
import com.limbo.practice.base.service.SysRoleResourceService;
import com.limbo.practice.core.base.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.controller
* @ClassName: SysRoleResourceController
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:11
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:11
*
* version V1.0
*/

@Api(tags = "系统角色资源关联")
@Controller
@RequestMapping("/sys-role-resource")
public class SysRoleResourceController extends BaseController<SysRoleResource, SysRoleResourceDao> {

    @Autowired
    private SysRoleResourceService<SysRoleResource, SysRoleResourceDao>  sysRoleResourceServiceImpl;

    @PostConstruct
    public void initService(){
        setService(sysRoleResourceServiceImpl);
    }

}
