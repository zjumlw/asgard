package com.will.asgard.thor.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName MethodInvokeLink
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-09-01 17:53
 * @Version 1.0
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MethodInvokeLink {

    String methodName() default "";
}