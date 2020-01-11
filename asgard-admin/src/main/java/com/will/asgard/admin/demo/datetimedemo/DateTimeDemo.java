package com.will.asgard.admin.demo.datetimedemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * Created by WillMao on 18-10-29
 */
public class DateTimeDemo {

	public static void main(String[] args) {
		// 新建一个时间，然后对该时间操作，并且格式化输出
		DateTime dateTime = new DateTime(2011, 11, 11, 11, 11, 11);
		dateTime = dateTime.plusDays(2);
		dateTime = dateTime.plusHours(2);
		dateTime = dateTime.plusYears(2);
		System.out.println(dateTime.toString("yy/MM/dd HH:mm:ss EE"));

		// 一当前时间点，新建一个时间，
		dateTime = new DateTime();
		dateTime = dateTime.minusSeconds(1);
		dateTime = dateTime.minusMinutes(1);
		dateTime = dateTime.minusHours(1);
		System.out.println(dateTime.toString("yy/MM/dd HH:mm:ss EE"));
		System.out.println(dateTime.toString("yyyy/MM/dd HH:mm:ss"));
		// DateTime转换为Calendar
		Calendar calendar = dateTime.toCalendar(new Locale("zh", "ZH"));
		System.out.println(calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH));

		// DateTime转换为jdk的Date
		DateFormat df = null;
		Date jkdDate = dateTime.toDate();
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(jkdDate));

		dateTimeConstructor();
	}

	private static void dateTimeConstructor() {
		System.out.println();
		DateTime dateTime = new DateTime(System.currentTimeMillis());
		System.out.println(dateTime);

		LocalDate localDate = dateTime.toLocalDate();
		System.out.println(localDate);
		LocalTime localTime = dateTime.toLocalTime();
		System.out.println(localTime);

	}
}
