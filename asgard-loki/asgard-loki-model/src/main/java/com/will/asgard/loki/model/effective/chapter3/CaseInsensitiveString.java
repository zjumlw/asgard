package com.will.asgard.loki.model.effective.chapter3;

/**
 * @ClassName CaseInsensitiveString
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-19 13:52
 * @Version 1.0
 **/
public class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		if (s == null) {
			throw new NullPointerException();
		}
		this.s = s;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof CaseInsensitiveString) {
			return s.equals(((CaseInsensitiveString) o).s);
		}
		if (o instanceof String) {
			return s.equals(o);
		}
		return false;
	}
}
