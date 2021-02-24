package com.limbo.practice.core.annotation;

import com.limbo.practice.core.constant.MenuLevelEnum;
import com.limbo.practice.core.constant.ResourceTypeEnum;
import com.limbo.practice.core.constant.RoleNameEnum;

import java.lang.annotation.ElementType;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@org.springframework.stereotype.Component
public @interface ApiResources {

    /**
     * 类型
     * @return
     */
    ResourceTypeEnum type() default ResourceTypeEnum.MENU;

    /**
     * 父节点
     * @return
     */
    MenuLevelEnum parent() default MenuLevelEnum.ROOT;

    /**
     * 角色名称
     * @return
     */
    RoleNameEnum roleName();

    /**
     * 排序
     * @return
     */
    int order() default 1;

    /**
     * 路由
     * @return
     */
    String route() default "";
}
