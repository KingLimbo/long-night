package com.limbo.practice.comm.service.impl;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.limbo.practice.comm.service.AnnotationService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.constant.CoreConsts;

import java.util.Set;

/**
 * 注解工具实现类
 *
 * @author limbo
 * @version 2021/2/22
 */
public class AnnotationServiceImpl implements AnnotationService {

    @Override
    public int autoGeneratorAllMenuResource() {
        Set<Class<?>> classSet = ClassUtil.scanPackageByAnnotation(CoreConsts.CORE_PACKAGE, ApiResources.class);
        if (CollectionUtil.isNotEmpty(classSet)) {
            classSet.forEach(c -> System.out.println(c.getName()));
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<Class<?>> classSet = ClassUtil.scanPackageByAnnotation(CoreConsts.CORE_PACKAGE, ApiResources.class);
        if (CollectionUtil.isNotEmpty(classSet)) {
            classSet.forEach(c -> System.out.println(c.getName()));
        }
    }
}
