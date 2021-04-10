package com.limbo.practice.comm.service.impl;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.comm.service.AnnotationService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.constant.CoreConsts;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Objects;
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
        // 获取所有的ApiResources注解标记的Controller
        Set<Class<?>> classSet = ClassUtil.scanPackageByAnnotation(CoreConsts.CORE_PACKAGE, ApiResources.class);
        if (CollectionUtil.isNotEmpty(classSet)) {
            classSet.forEach(c -> {
                System.out.println(c.getName());
                // 获取ApiResources注解
                ApiResources annotation = AnnotationUtil.getAnnotation(c, ApiResources.class);
                RoleNameEnum roleNameEnum = annotation.roleName();
                String route = annotation.route();
                ResourceTypeEnum type = annotation.type();
                MenuLevelEnum parent = annotation.parent();
                int order = annotation.order();
                SysResource sysResource = new SysResource();
                sysResource.setType(type);
                sysResource.setParentId(Long.valueOf(parent.getValue()));
                sysResource.setSort(order);
                RequestMapping requestMapping = c.getAnnotation(RequestMapping.class);
                if (Objects.nonNull(requestMapping)) {
                    System.out.println(requestMapping.value()[0]);
                }
                Method[] methods = c.getMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        GetMapping get = method.getAnnotation(GetMapping.class);
                        if (Objects.nonNull(get)) {
                            System.out.println(get.value()[0]);
                            continue;
                        }
                        PutMapping put = method.getAnnotation(PutMapping.class);
                        if (Objects.nonNull(put)) {
                            System.out.println(put.value()[0]);
                            continue;
                        }
                        PatchMapping patch = method.getAnnotation(PatchMapping.class);
                        if (Objects.nonNull(patch)) {
                            System.out.println(patch.value()[0]);
                            continue;
                        }
                        DeleteMapping delete = method.getAnnotation(DeleteMapping.class);
                        if (Objects.nonNull(delete)) {
                            System.out.println(delete.value()[0]);
                            continue;
                        }
                    }
                }
            });
        }
        return 0;
    }

}
