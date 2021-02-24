/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.limbo.practice.core.base.BaseController;
import com.limbo.practice.base.dao.SysRoleResourceDao;
import com.limbo.practice.base.entity.SysRoleResource;

import com.limbo.practice.base.service.SysRoleResourceService;

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

@Controller
public class SysRoleResourceController extends BaseController {
    @Autowired
    private SysRoleResourceService<SysRoleResourceDao,SysRoleResource>  sysRoleResourceServiceImpl;
}
