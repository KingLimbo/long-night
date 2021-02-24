/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import org.springframework.stereotype.Service;

import com.limbo.practice.core.base.BaseServiceImpl;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.service.SysResourceService;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.service.impl
* @ClassName: SysResourceService
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:09
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:09
*
* version V1.0
*/

@Service
public class SysResourceServiceImpl extends BaseServiceImpl<SysResourceDao,SysResource> implements SysResourceService<SysResourceDao,SysResource> {

    @Override
    public void scanApiResource() {

    }
}
