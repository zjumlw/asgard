package com.will.asgard.loki.model.effective.chapter6;

/**
 * @ClassName PayrollDay
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-02 17:59
 * @Version 1.0
 **/
public enum  PayrollDay {
	MONDAY(PayType.WEEKDAY),
	TUESDAY(PayType.WEEKDAY),
	WEDNESDAY(PayType.WEEKDAY),
	THURSDAY(PayType.WEEKDAY),
	FRIDAY(PayType.WEEKDAY),
	SATURDAY(PayType.WEEKEND),
	SUNDAY(PayType.WEEKEND),
	;

	private final PayType payType;

	PayrollDay(PayType payType) {
		this.payType = payType;
	}

	double pay(double hoursWorked, double payRate) {
		return payType.pay(hoursWorked, payRate);
	}

	private enum PayType {
		WEEKDAY {
			@Override
			double overtimePay(double hours, double parRate) {
				return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * parRate / 2;
			}
		},
		WEEKEND {
			@Override
			double overtimePay(double hours, double parRate) {
				return hours * parRate / 2;
			}
		}
		;

		private static final int HOURS_PER_SHIFT = 8;

		abstract double overtimePay(double hours, double parRate);

		double pay(double hoursWorked, double payRate) {
			double basePay = hoursWorked * payRate;
			return basePay + overtimePay(hoursWorked, payRate);
		}
	}
}
