/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import org.springframework.stereotype.Service;

import com.limbo.practice.core.base.BaseServiceImpl;
import com.limbo.practice.base.dao.SysUserDao;
import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.base.service.SysUserService;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.service.impl
* @ClassName: SysUserService
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:12
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:12
*
* version V1.0
*/

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao,SysUser> implements SysUserService<SysUserDao,SysUser> {

}
