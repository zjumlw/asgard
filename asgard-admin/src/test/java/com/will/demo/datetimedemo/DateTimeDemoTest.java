package com.will.demo.datetimedemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

/**
 * Created by WillMao on 18-10-29
 */
public class DateTimeDemoTest {

	@Test
	public void testDateTimeConstructor() {
		// 默认构造器，当前时间
		DateTime dateTime = new DateTime();
		System.out.println(dateTime);

		// 传入Date类对象
		Date date = new Date();
		DateTime dateTime1 = new DateTime(date);
		System.out.println(dateTime1);

		// 传入Calendar单例对象
		Calendar calendar = Calendar.getInstance();
		DateTime dateTime2 = new DateTime(calendar);
		System.out.println(dateTime2);

		// 传入String类formatted时间
		String timeString = "2006-01-26";
		DateTime dateTime3 = new DateTime(timeString);
		System.out.println(dateTime3);
	}

	@Test
	public void testLocalDateAndLocalTime() {
		DateTime dateTime = new DateTime();
		LocalDate localDate = dateTime.toLocalDate();
		LocalTime localTime = dateTime.toLocalTime();
		System.out.println(localDate);
		System.out.println(localTime);
	}

	@Test
	public void testCalculate() {
		DateTime now = new DateTime();
		LocalDate lastDayOfPreviousMonth = now.minusMonths(1).dayOfMonth().withMaximumValue().toLocalDate();
		System.out.println(lastDayOfPreviousMonth);
		LocalDate lastDayOfPreviousWeek = now.minusWeeks(1).dayOfWeek().withMaximumValue().toLocalDate();
		System.out.println(lastDayOfPreviousWeek);
		LocalDate lastDayOfThisMonth = now.dayOfMonth().withMaximumValue().toLocalDate();
		System.out.println(lastDayOfThisMonth);
		LocalDate lastDayOfThisWeek = now.dayOfWeek().withMaximumValue().toLocalDate();
		System.out.println(lastDayOfThisWeek);

		// 计算 11 月中第一个星期一之后的第一个星期二
		LocalDate electionDate = now.monthOfYear().setCopy(11).dayOfMonth().withMinimumValue().plusDays(6).dayOfWeek()
				.setCopy(1).plusDays(1).toLocalDate();
		System.out.println(electionDate);
	}

	@Test
	public void testTransform() {
		DateTime dateTime = new DateTime();
		System.out.println(dateTime.toLocalDate());
		// DateTime to calendar
		Calendar calendar = dateTime.toCalendar(Locale.getDefault());
		// DateTime to date
		Date date = dateTime.toDate();
		System.out.println(calendar);
		System.out.println(date);
		// LocalDate to date
		LocalDate localDate = dateTime.toLocalDate();
		Date date1 = localDate.toDate();
		long startTimeStamp = date1.getTime();
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1) + " = " + startTimeStamp);

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTimeInMillis(localDate.toDateTimeAtStartOfDay().getMillis());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar1.getTime()));
	}
}