package com.will.asgard.loki.model.effective.chapter3;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {

	@Test
	public void test() {
		PhoneNumber pn = new PhoneNumber(707, 867, 5309);
		PhoneNumber pn2 = new PhoneNumber(707, 867, 5309);
		Assert.assertEquals(pn, pn2);

		Map<PhoneNumber, String> map = new HashMap<>();
		map.put(pn, "Jenny");
		String name = map.get(pn);
		Assert.assertEquals("Jenny", name);

		String name2 = map.get(pn2);
		Assert.assertEquals("Jenny", name2);

		System.out.println(pn.toString());
	}
}