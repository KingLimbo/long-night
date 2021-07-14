/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service;

import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.core.base.BaseService;

import java.util.List;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.service
* @ClassName: ISysUserService
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:12
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:12
*
* version V1.0
*/
public interface SysUserService<T, D> extends BaseService<T, D> {


    List<SysResource> getMenuByUserId(Long userId);
}
