package com.will.asgard.loki.model.effective.chapter3;

import lombok.Data;

/**
 * @ClassName PhoneNumber
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-19 16:23
 * @Version 1.0
 **/
public class PhoneNumber {
	private final int areaCode;
	private final int prefix;
	private final int lineNumber;
	private volatile int hashCode;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNumber == lineNumber
				&& pn.prefix == prefix
				&& pn.areaCode == areaCode;
	}

	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0) {
			result = 17;
			result = result * 31 + areaCode;
			result = result * 31 + prefix;
			result = result * 31 + lineNumber;
			hashCode = result;
		}
		return result;
	}

	@Override
	public PhoneNumber clone() {
		try {
			return (PhoneNumber) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	private static void rangeCheck(int arg, int max, String name) {
		if (arg < 0 || arg > max) {
			throw new IllegalArgumentException(name + ": " + arg);
		}
	}
}
