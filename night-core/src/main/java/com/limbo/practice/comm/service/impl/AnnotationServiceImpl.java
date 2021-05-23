package com.limbo.practice.comm.service.impl;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.service.SysResourceService;
import com.limbo.practice.comm.service.AnnotationService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 注解工具实现类
 *
 * @author limbo
 * @version 2021/2/22
 */
@Service
public class AnnotationServiceImpl implements AnnotationService {

    @Autowired
    private SysResourceService sysResourceServiceImpl;

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

    @Transactional(rollbackFor = Exception.class)
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
                Api api = AnnotationUtil.getAnnotation(c, Api.class);
                if (Objects.isNull(api)) {
                    return resources;
                }
                controllerResource.setName(api.tags()[0]);
                controllerId = sysResourceServiceImpl.insertDb(controllerResource);
            }
            Method[] methods = c.getMethods();
            if (ArrayUtil.isNotEmpty(methods)) {
                for (Method method : methods) {
                    SysResource methodResource = new SysResource();
                    BeanUtils.copyProperties(sysResource, methodResource);
                    ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
                    if (Objects.nonNull(apiOperation)) {
                        methodResource.setName(apiOperation.value());
                    } else {
                        continue;
                    }
                    String mUrl = "";
                    GetMapping get = method.getAnnotation(GetMapping.class);
                    if (Objects.nonNull(get)) {
                        mUrl = get.value()[0];
                        methodResource.setUrlType("GET");
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
                    methodResource.setUrl(replaceAllUrlParams(mUrl));
                    methodResource.setParentId(controllerId);
                    methodResource.setParents(sysResource.getParents() + StrUtil.C_COMMA + controllerId.toString());
                    sysResourceServiceImpl.insertDb(methodResource);
                }
            }
            return resources;
        }
        return Lists.newArrayList();
    }

    private String replaceAllUrlParams(String url) {
        String str = "";
        if (StrUtil.isNotBlank(url)) {
            String pattern = "\\{[a-zA-Z0-9-]*}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(url);
            str = m.replaceAll(".*");
        }
        return str;
    }
}