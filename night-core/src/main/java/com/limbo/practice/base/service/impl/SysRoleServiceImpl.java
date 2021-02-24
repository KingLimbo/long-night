/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import org.springframework.stereotype.Service;

import com.limbo.practice.core.base.BaseServiceImpl;
import com.limbo.practice.base.dao.SysRoleDao;
import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.base.service.SysRoleService;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.service.impl
* @ClassName: SysRoleService
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:10
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:10
*
* version V1.0
*/

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao,SysRole> implements SysRoleService<SysRoleDao,SysRole> {

}
