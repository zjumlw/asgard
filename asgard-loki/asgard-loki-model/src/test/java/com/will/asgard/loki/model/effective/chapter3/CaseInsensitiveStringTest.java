package com.will.asgard.loki.model.effective.chapter3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaseInsensitiveStringTest {

	@Test
	public void test() {
		CaseInsensitiveString caseInsensitiveString =new CaseInsensitiveString("hello");
		String str = "hello";
		Assert.assertTrue(caseInsensitiveString.equals(str));
		Assert.assertTrue(!str.equals(caseInsensitiveString));
	}

	@Test
	public void test2() {
		CaseInsensitiveString caseInsensitiveString =new CaseInsensitiveString("hello");
		String str = "hello";
		List<CaseInsensitiveString> list = new ArrayList<>();
		list.add(caseInsensitiveString);
		System.out.println(list.contains(str));
	}

	@Test
	public void test3() {
		double x= 300000.00000000003;//double比较，小数点后有效位
		double y= 300000.000000000003;//主要注意的是double类型直接==/>=/<=的比较，涉及到有效位
		System.out.println(x<=300000);
		System.out.println(y<=300000);

		System.out.println(Double.compare(x, 300000));
		System.out.println(Double.compare(y, 300000));

		BigDecimal num1 = new BigDecimal(x);
		BigDecimal num2 = new BigDecimal(String.valueOf(y));
		BigDecimal target = new BigDecimal(300000);

		boolean res = num2.equals(target);
		System.out.println(res);

		System.out.println(new BigDecimal(0.1).toString());
		System.out.println(new BigDecimal(
				Double.toString(0.1000000000000000055511151231257827021181583404541015625)).toString()); // 0.1
		System.out.println(new BigDecimal(Double.toString(0.1)).toString()); // 0.1

		int x1 = (int) 1023.99999999999999; // x=1024为什么？
		System.out.println(x1);
	}
}