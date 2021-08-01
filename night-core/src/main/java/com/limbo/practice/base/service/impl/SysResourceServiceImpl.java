/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.service.impl;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.dao.SysRoleDao;
import com.limbo.practice.base.dao.SysRoleResourceDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.base.entity.SysRoleResource;
import com.limbo.practice.base.service.SysResourceService;
import com.limbo.practice.base.service.SysRoleResourceService;
import com.limbo.practice.base.service.SysRoleService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.base.BaseServiceImpl;
import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
import com.limbo.practice.core.util.UtilPath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
public class SysResourceServiceImpl extends BaseServiceImpl<SysResource, SysResourceDao> implements SysResourceService<SysResource, SysResourceDao> {


    @Autowired
    private SysRoleService<SysRole, SysRoleDao> sysRoleService;
    @Autowired
    private SysRoleResourceService<SysRoleResource, SysRoleResourceDao> sysRoleResourceService;

    @Override
    public List<SysResource> autoGeneratorAllMenuResource() {
        List<SysResource> resources = Lists.newArrayList();
        // 获取所有的ApiResources注解标记的Controller
        Set<Class<?>> classSet = ClassUtil.scanPackageByAnnotation(CoreConsts.CORE_PACKAGE, ApiResources.class);
        if (CollectionUtil.isNotEmpty(classSet)) {
            classSet.forEach(aClass -> {
                resources.addAll(scanController(aClass));
            });
        }
        return resources;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public List<SysResource> scanController(Class c) {
        System.out.println(c.getName());
        // 获取ApiResources注解
        ApiResources annotation = AnnotationUtil.getAnnotation(c, ApiResources.class);
        if (Objects.nonNull(annotation)) {
            List<SysResource> resources = Lists.newArrayList();
            RoleNameEnum roleNameEnum = annotation.roleName();
            String route = annotation.route();
            ResourceTypeEnum type = annotation.type();
            MenuLevelEnum parent = annotation.parent();
            int order = annotation.order();
            SysResource sysResource = new SysResource();
            sysResource.setType(type);
            sysResource.setParentId(Long.valueOf(parent.getValue()));
            sysResource.setParents(parent.getParents() + StrUtil.C_COMMA + sysResource.getParentId().toString());
            sysResource.setSort(order);
            RequestMapping requestMapping = (RequestMapping) c.getAnnotation(RequestMapping.class);
            String cUrl = "";
            Long controllerId = null;
            if (Objects.nonNull(requestMapping)) {
                cUrl = requestMapping.value()[0];
                SysResource controllerResource = new SysResource();
                BeanUtils.copyProperties(sysResource, controllerResource);
                controllerResource.setUrl(cUrl);
                controllerResource.setUrlType("GET");
                controllerResource.setRoute(route);
                controllerResource.setAutoGeneration(true);
                Api api = AnnotationUtil.getAnnotation(c, Api.class);
                if (Objects.isNull(api)) {
                    return resources;
                } else {
                    controllerResource.setName(api.tags()[0]);
                }
                SysResource old = get((SysResource) new SysResource().setName(controllerResource.getName()).setUrl(controllerResource.getUrl()));
                Set<Long> ids = Sets.newHashSet();
                if (Objects.nonNull(old)) {
                    ids = dao.selectChildAndSelfById(old.getId());
                    if (CollectionUtil.isNotEmpty(ids)) {
                        ids.forEach(this::delete);
                    }
                }
                resources.add(controllerResource);
                controllerId = insertDb(controllerResource);
                if (Objects.nonNull(roleNameEnum)) {
                    SysRole sysRole = sysRoleService.getById((long) roleNameEnum.getValue());
                    if (Objects.isNull(sysRole)) {
                        sysRoleService.insertDb((SysRole) new SysRole().setName(roleNameEnum.getName()).setAutoGeneration(true).setId((long)roleNameEnum.getValue()));
                    } else {
                        sysRoleResourceService.deleteByRoleIdResourceIds(sysRole.getId(), ids);
                    }
                }
            }
            Method[] methods = c.getMethods();
            if (ArrayUtil.isNotEmpty(methods)) {
                for (Method method : methods) {
                    SysResource methodResource = new SysResource();
                    BeanUtils.copyProperties(sysResource, methodResource);
                    methodResource.setType(ResourceTypeEnum.RESOURCE);
                    ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
                    if (Objects.nonNull(apiOperation)) {
                        methodResource.setName(apiOperation.value());
                    } else {
                        continue;
                    }
                    String mUrl = "";
                    GetMapping get = method.getAnnotation(GetMapping.class);
                    if (Objects.nonNull(get)) {
                        mUrl = get.value()[0] + "*";
                        methodResource.setUrlType("GET");
                        resources.add(methodResource);
                    }
                    PostMapping post = method.getAnnotation(PostMapping.class);
                    if (Objects.nonNull(post)) {
                        mUrl = post.value()[0];
                        methodResource.setUrlType("POST");
                        resources.add(methodResource);
                    }
                    PutMapping put = method.getAnnotation(PutMapping.class);
                    if (Objects.nonNull(put)) {
                        mUrl = put.value()[0];
                        methodResource.setUrlType("PUT");
                        resources.add(methodResource);
                    }
                    PatchMapping patch = method.getAnnotation(PatchMapping.class);
                    if (Objects.nonNull(patch)) {
                        mUrl = patch.value()[0];
                        methodResource.setUrlType("PATCH");
                        resources.add(methodResource);
                    }
                    DeleteMapping delete = method.getAnnotation(DeleteMapping.class);
                    if (Objects.nonNull(delete)) {
                        mUrl = delete.value()[0];
                        methodResource.setUrlType("DELETE");
                        resources.add(methodResource);
                    }

                    mUrl = cUrl + mUrl;
                    methodResource.setUrl(UtilPath.replaceAllUrlParams(mUrl));
                    methodResource.setParentId(controllerId);
                    methodResource.setParents(sysResource.getParents() + StrUtil.C_COMMA + controllerId.toString());
                    methodResource.setAutoGeneration(true);
                    insertDb(methodResource);
                }
            }
            resources.forEach(o -> {sysRoleResourceService.insertDb((SysRoleResource) new SysRoleResource().setRoleId((long) roleNameEnum.getValue()).setResourceId(o.getId()));});
            return resources;
        }
        return Lists.newArrayList();
    }

    @Override
    public void deleteByPid(Long pid) {
        if (Objects.nonNull(pid)) {
            dao.deleteByPid(pid);
        }
    }

}