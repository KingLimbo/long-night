/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.controller;

import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.constant.RoleNameEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.limbo.practice.core.base.BaseController;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.entity.SysResource;

import com.limbo.practice.base.service.SysResourceService;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.controller
* @ClassName: SysResourceController
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:09
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:09
*
* version V1.0
*/
@ApiResources(roleName = RoleNameEnum.ADMIN)
@Controller
public class SysResourceController extends BaseController {
    @Autowired
    private SysResourceService<SysResourceDao,SysResource>  sysResourceServiceImpl;
}
