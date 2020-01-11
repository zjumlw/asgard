package com.will.asgard.common.annotaion;

import java.lang.annotation.Inherited;

@Inherited
public @interface Greeting {

	enum FontColor {
		BLUE, RED, GREEN
	}

	String name();

	FontColor fontColor() default FontColor.RED;

}
