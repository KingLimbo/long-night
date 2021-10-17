/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service;

import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.core.base.BaseService;

import java.util.Set;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.service
* @ClassName: ISysRoleService
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:10
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:10
*
* version V1.0
*/
public interface SysRoleService<T, D> extends BaseService<T, D> {

    /**
     * 通过用户id查询角色
     *
     * @param userId
     * @return
     */
    Set<SysRole> listRoleByUserId(Long userId);
}
