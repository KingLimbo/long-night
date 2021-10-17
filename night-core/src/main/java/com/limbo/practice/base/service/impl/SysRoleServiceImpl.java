/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import com.limbo.practice.base.dao.SysRoleDao;
import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.base.service.SysRoleService;
import com.limbo.practice.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

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
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, SysRoleDao> implements SysRoleService<SysRole, SysRoleDao> {

    @Override
    public Set<SysRole> listRoleByUserId(Long userId) {
        if (Objects.nonNull(userId)) {
            return dao.listRoleByUserId(userId);
        }
        return null;
    }
}
