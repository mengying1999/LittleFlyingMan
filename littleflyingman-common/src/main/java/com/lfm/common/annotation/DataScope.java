package com.lfm.common.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 * 
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * 学院表的别名
     */
    public String collegeAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";
}
