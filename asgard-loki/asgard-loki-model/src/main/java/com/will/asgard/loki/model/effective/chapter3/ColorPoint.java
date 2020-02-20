package com.will.asgard.loki.model.effective.chapter3;

/**
 * @ClassName ColorPoint
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-02-20 13:23
 * @Version 1.0
 **/
public class ColorPoint {
	private final Point point;
	private final Color color;

	public ColorPoint(Point point, Color color) {
		this.point = point;
		this.color = color;
	}

	public ColorPoint(int x, int y, Color color) {
		if (color == null) {
			throw new NullPointerException();
		}
		this.color = color;
		this.point = new Point(x, y);
	}

	/**
	 * Returns the point-view of this color point
	 */
	public Point asPoint() {
		return this.point;
	}
}
