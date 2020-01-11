package com.will.asgard.common.core.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {

	boolean firstLevelCache() default false;

	boolean secondLevelCache() default true;

	String tableName() default "";

	String split() default "";

}
