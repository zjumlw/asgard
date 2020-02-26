package com.will.asgard.loki.model.effective.chapter7;

import java.util.Date;

/**
 * @ClassName Period
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-25 16:55
 * @Version 1.0
 **/
public class Period {
	private final Date start;
	private final Date end;

	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
	}

	// make defensive copies of internal fields
	public Date start() {
		return new Date(this.start.getTime());
	}

	public Date end() {
		return new Date(this.end.getTime());
	}
}
