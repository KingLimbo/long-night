/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.limbo.practice.base.dao.SysRoleResourceDao;
import com.limbo.practice.base.entity.SysRoleResource;
import com.limbo.practice.base.service.SysRoleResourceService;
import com.limbo.practice.core.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.service.impl
* @ClassName: SysRoleResourceService
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:11
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:11
*
* version V1.0
*/
@Service
public class SysRoleResourceServiceImpl extends BaseServiceImpl<SysRoleResource, SysRoleResourceDao>  implements SysRoleResourceService<SysRoleResource, SysRoleResourceDao> {

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public void deleteByRoleIdResourceIds(Long roleId, Set<Long> resourceIds) {
        if (Objects.nonNull(roleId) && CollectionUtil.isNotEmpty(resourceIds)) {
            dao.deleteByRoleIdResourceIds(roleId, resourceIds);
        }
    }
}
