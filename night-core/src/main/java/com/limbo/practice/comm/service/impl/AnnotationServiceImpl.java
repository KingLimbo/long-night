package com.limbo.practice.comm.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ClassUtil;
import com.google.common.collect.Lists;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.service.SysResourceService;
import com.limbo.practice.comm.service.AnnotationService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.constant.CoreConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 注解工具实现类
 *
 * @author limbo
 * @version 2021/2/22
 */
@Service
public class AnnotationServiceImpl implements AnnotationService {

    @Autowired
    private SysResourceService<SysResource, SysResourceDao> sysResourceServiceImpl;

    @Override
    public List<SysResource> autoGeneratorAllMenuResource() {
        List<SysResource> resources = Lists.newArrayList();
        // 获取所有的ApiResources注解标记的Controller
        Set<Class<?>> classSet = ClassUtil.scanPackageByAnnotation(CoreConsts.CORE_PACKAGE, ApiResources.class);
        if (CollectionUtil.isNotEmpty(classSet)) {
            classSet.forEach(aClass -> {
                resources.addAll(sysResourceServiceImpl.scanController(aClass));
            });
        }
        return resources;
    }


}