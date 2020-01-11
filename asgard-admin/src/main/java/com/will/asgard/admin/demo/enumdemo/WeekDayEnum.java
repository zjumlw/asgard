package com.will.asgard.admin.demo.enumdemo;

import java.util.EnumSet;

/**
 * Created by WillMao on 18-10-29
 */
public enum WeekDayEnum {
	MON("星期一"), TUE("星期二"), WED("星期三"), THU("星期四"), FRI("星期五"), SAT("星期六"), SUN("星期日");
	private String description;

	private WeekDayEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0) + lower;
	}

	public static void main(String[] args) {
		for (WeekDayEnum day : EnumSet.range(WeekDayEnum.MON, WeekDayEnum.FRI)) {
			System.out.println(day.toString() + " " + day.ordinal() + " " + day.getDescription());
		}

	}
}
