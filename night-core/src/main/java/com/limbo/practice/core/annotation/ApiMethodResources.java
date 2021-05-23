package com.limbo.practice.core.annotation;

import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;

import java.lang.annotation.ElementType;

@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@org.springframework.stereotype.Component
public @interface ApiMethodResources {

    /**
     * 资源类型
     *
     * @return
     */
    ResourceTypeEnum type() default ResourceTypeEnum.RESOURCE;

    /**
     * 父级
     *
     * @return
     */
    MenuLevelEnum parent() default MenuLevelEnum.ROOT;

    /**
     * 角色
     *
     * @return
     */
    RoleNameEnum roleName();

    /**
     * 名称
     *
     * @return
     */
    String name() default "";

    /**
     * 排序
     *
     * @return
     */
    int order() default 1;

    /**
     * 路由
     *
     * @return
     */
    String route() default "";
}
