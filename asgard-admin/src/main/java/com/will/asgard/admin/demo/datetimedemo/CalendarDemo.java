package com.will.asgard.admin.demo.datetimedemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by WillMao on 18-10-29
 */
public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		System.out.println(year + " " + month + " " + day + " " + hour + " " + minute + " " + second);

		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

		Date jdkDate = calendar.getTime();

		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateStr = format.format(jdkDate);

		System.out.println(dateStr);
	}
}
