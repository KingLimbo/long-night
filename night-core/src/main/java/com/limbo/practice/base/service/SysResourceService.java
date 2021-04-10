/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service;

import com.limbo.practice.core.base.BaseService;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.service
* @ClassName: ISysResourceService
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:09
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:09
*
* version V1.0
*/
public interface SysResourceService<T, D> extends BaseService<T, D> {

    void scanApiResource();
}
