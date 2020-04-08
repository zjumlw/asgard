package com.will.asgard.loki.model.tax;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName Income
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-07 21:30
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public class Income {
	private static final double DEFAULT_SOCIAL_SECURITY = 4115.50;

	private int month;
	private double beforeTax;
	private double socialSecurity;
	private double tax;
	private double totalGet;

	public Income(int month, double beforeTax, double totalGet) {
		this.month = month;
		this.beforeTax = beforeTax;
		this.totalGet = totalGet;
		this.socialSecurity = DEFAULT_SOCIAL_SECURITY;
		this.tax = this.beforeTax - this.socialSecurity - this.totalGet;
	}
}
