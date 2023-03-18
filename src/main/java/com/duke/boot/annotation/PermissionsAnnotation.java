package com.duke.boot.annotation;

import java.lang.annotation.*;

/**
 * @author: dengkun11
 * @date: 2022/08/11
 * @description: 自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionsAnnotation {
}
