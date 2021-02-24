package com.limbo.practice.core.annotation;

import com.limbo.practice.core.constant.MenuLevelEnum;
import com.limbo.practice.core.constant.ResourceTypeEnum;
import com.limbo.practice.core.constant.RoleNameEnum;

import java.lang.annotation.ElementType;

@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@org.springframework.stereotype.Component
public @interface ApiMethodResources {

    ResourceTypeEnum type() default ResourceTypeEnum.RESOURCE;

    MenuLevelEnum parent() default MenuLevelEnum.ROOT;

    RoleNameEnum roleName();

    String name() default "";

    int order() default 1;

    String route() default "";
}
