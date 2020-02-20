package com.will.asgard.loki.model.effective.chapter3;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Point
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-20 13:21
 * @Version 1.0
 **/
@Getter
@Setter
public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return x == point.x &&
				y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
