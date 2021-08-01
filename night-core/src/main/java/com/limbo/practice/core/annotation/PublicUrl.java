package com.limbo.practice.core.annotation;

import java.lang.annotation.ElementType;

@java.lang.annotation.Target({ElementType.TYPE, ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
/**
 * 公共请求url，不验证权限
 */
public @interface PublicUrl {
}
