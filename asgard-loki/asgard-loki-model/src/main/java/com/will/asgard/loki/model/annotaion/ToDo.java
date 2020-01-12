package com.will.asgard.loki.model.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToDo {

	enum Priority {
		LOW, MEDIUM, HIGH
	}

	enum Status {
		STARTED, NOT_STARTED
	}

	String author() default "Will";

	Priority priority() default Priority.LOW;

	Status status() default Status.NOT_STARTED;

}
