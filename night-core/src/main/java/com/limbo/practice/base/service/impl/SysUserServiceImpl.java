/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import com.google.common.collect.Lists;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.dao.SysRoleDao;
import com.limbo.practice.base.dao.SysUserDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.base.entity.ro.SysUserRO;
import com.limbo.practice.base.entity.vo.SysUserVO;
import com.limbo.practice.base.service.SysResourceService;
import com.limbo.practice.base.service.SysRoleService;
import com.limbo.practice.base.service.SysUserService;
import com.limbo.practice.core.base.BaseServiceImpl;
import com.limbo.practice.core.base.PageRO;
import com.limbo.practice.core.base.PageTableBean;
import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.util.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @ProjectName: long-night
 * @PackageName: com.limbo.practice.base.service.impl
 * @ClassName: SysUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: limbo
 * @Date: 2021-02-20 09:46:12
 * @Modifier: limbo
 * @ModifiedDate: 2021-02-20 09:46:12
 * <p>
 * version V1.0
 */

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserDao> implements SysUserService<SysUser, SysUserDao> {

    @Autowired
    private SysResourceService<SysResource, SysResourceDao> sysResourceService;
    @Autowired
    private SysRoleService<SysRole, SysRoleDao> sysRoleServiceImpl;

    @Override
    public List<SysResource> getMenuByUserId(Long userId) {
        SysResource sysResource = new SysResource();
        sysResource.setIds(dao.selectResourceIdByUserId(userId));
        sysResource.setTypes(Lists.newArrayList(ResourceTypeEnum.MENU, ResourceTypeEnum.CONTENTS));
        PageTableBean pageTableBean = sysResourceService.queryList(sysResource);
        List<SysResource> data = (List<SysResource>) pageTableBean.getData();
        return data;
    }

    @Override
    public PageTableBean pageUsers(SysUserRO ro) {
        PageTableBean pageTableBean = new PageTableBean();
        try {
            SysUser sysUser = PageRO.toBean(ro, SysUser.class);
            List<SysUser> list = dao.list(sysUser);
            List<SysUserVO> voList = PageRO.toListBean(list, SysUserVO.class);
            voList.forEach(vo -> {
                Set<SysRole> sysRoles = sysRoleServiceImpl.listRoleByUserId(vo.getId());
                vo.setRoles(sysRoles);
            });
            pageTableBean.setData(voList);
            pageTableBean.setCode(CoreConsts.CODE_NORMAL);
            pageTableBean.setCount((long) voList.size());
        } catch (Exception e) {
            LoggerUtils.fmtError(BaseServiceImpl.class, e, "分页查询失败");
            pageTableBean.setCode(CoreConsts.CODE_ERROR);
            pageTableBean.setMsg(e.getMessage());
        }
        return pageTableBean;
    }
}
