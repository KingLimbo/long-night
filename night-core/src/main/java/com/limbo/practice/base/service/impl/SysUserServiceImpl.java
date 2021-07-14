/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import com.google.common.collect.Lists;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.dao.SysUserDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.base.service.SysResourceService;
import com.limbo.practice.base.service.SysUserService;
import com.limbo.practice.core.base.BaseServiceImpl;
import com.limbo.practice.core.base.PageTableBean;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private SysResourceService<SysResource, SysResourceDao> sysResourceService;

    @Override
    public List<SysResource> getMenuByUserId(Long userId) {
        SysResource sysResource = new SysResource();
        sysResource.setIds(dao.selectResourceIdByUserId(userId));
        sysResource.setTypes(Lists.newArrayList(ResourceTypeEnum.MENU, ResourceTypeEnum.CONTENTS));
        PageTableBean pageTableBean = sysResourceService.queryList(sysResource);
        List<SysResource> data = (List<SysResource>) pageTableBean.getData();
        return data;
    }
}
