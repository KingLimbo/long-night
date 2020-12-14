package com.limbo.practice.core.mybatis;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
@org.springframework.stereotype.Component
/**
 * @author limbo
 */
public @interface MybatisDao {
    /**
     *
     * @return
     */
    java.lang.String value() default "";
}
