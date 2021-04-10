/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import com.limbo.practice.base.dao.SysUserDao;
import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.base.service.SysUserService;
import com.limbo.practice.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

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
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserDao> implements SysUserService<SysUser, SysUserDao> {

}
