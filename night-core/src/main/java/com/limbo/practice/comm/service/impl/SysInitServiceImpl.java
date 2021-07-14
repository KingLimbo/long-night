package com.limbo.practice.comm.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.dao.SysRoleDao;
import com.limbo.practice.base.dao.SysRoleResourceDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.base.entity.SysRoleResource;
import com.limbo.practice.base.service.SysResourceService;
import com.limbo.practice.base.service.SysRoleResourceService;
import com.limbo.practice.base.service.SysRoleService;
import com.limbo.practice.comm.service.SysInitService;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 系统初始化service.impl
 *
 * @author limbo
 * @version 2021/3/5
 */
@Service
@Slf4j
public class SysInitServiceImpl implements SysInitService {

    @Autowired
    private SysRoleService<SysRole, SysRoleDao> sysRoleService;
    @Autowired
    private SysResourceService<SysResource, SysResourceDao> sysResourceService;
    @Autowired
    private SysRoleResourceService<SysRoleResource, SysRoleResourceDao> sysRoleResourceService;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public void initRole() {
        List<SysRole> data = new ArrayList<>();
        for (RoleNameEnum roleNameEnum : RoleNameEnum.values()) {
          SysRole role = new SysRole();
          role.setId(Long.valueOf(roleNameEnum.getValue()));
          role.setName(roleNameEnum.getName());
          role.setAutoGeneration(true);
          data.add(role);
        }
        if (CollectionUtil.isNotEmpty(data)) {
            log.info("初始化角色");
            sysRoleService.insertBatch(data);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public void initMenuLevel() {
        log.info("初始化菜单文件夹");
        for (MenuLevelEnum menuLevelEnum : MenuLevelEnum.values()) {
            SysResource sysResource = new SysResource();
            sysResource.setName(menuLevelEnum.getName());
            sysResource.setId((long) menuLevelEnum.getValue());
            MenuLevelEnum parent = menuLevelEnum.getParent();
            if (Objects.nonNull(parent)) {
                sysResource.setParentId(Long.valueOf(parent.getValue()));
                sysResource.setParents(menuLevelEnum.getParents());
            }
            sysResource.setSort(menuLevelEnum.getSort());
            sysResource.setType(ResourceTypeEnum.CONTENTS);
            sysResource.setAutoGeneration(true);
            Long sysResourceId = sysResourceService.insertDb(sysResource);
            Set<RoleNameEnum> roles = menuLevelEnum.getRoles();
            for (RoleNameEnum role : roles) {
                Long roleId = Long.valueOf(role.getValue());
                SysRoleResource roleResource = new SysRoleResource();
                roleResource.setRoleId(roleId);
                roleResource.setResourceId(sysResourceId);
                sysRoleResourceService.insertDb(roleResource);
            }

        }
    }
}
