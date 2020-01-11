package com.will.asgard.admin.demo.datetimedemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WillMao on 18-10-29
 */
public class DateDemo {

	public static void main(String[] args) {
		Date jdkDate = new Date();

		int year = jdkDate.getYear();
		int month = jdkDate.getMonth();
		int day = jdkDate.getDate();
		int hour = jdkDate.getHours();
		int minute = jdkDate.getMinutes();
		int second = jdkDate.getSeconds();

		System.out.println(year + " " + month + " " + day + " " + hour + " " + minute + " " + second);

		jdkDate = new Date(year, month, day, hour, minute, second);
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateStr = format.format(jdkDate);

		System.out.println(dateStr);

	}
}
