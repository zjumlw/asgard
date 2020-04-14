package com.will.asgard.loki.model.concurrent.chapter6;

import java.util.concurrent.locks.StampedLock;

/**
 * @ClassName Point
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-14 01:10
 * @Version 1.0
 **/
public class Point {
	private final StampedLock stampedLock = new StampedLock();

	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	private void move(double deltaX, double deltaY) {
		long stamp = stampedLock.writeLock();
		System.out.println("stamp=" + stamp);
		try {
			x += deltaX;
			y += deltaY;
		} finally {
			stampedLock.unlockWrite(stamp);
		}
	}

	private double distanceFromOrigin() {
		long stamp = stampedLock.tryOptimisticRead();
		double currentX = x;
		double currentY = y;
		if (!stampedLock.validate(stamp)) {
			stamp = stampedLock.readLock();
			try {
				currentX = x;
				currentY = y;
			} finally {
				stampedLock.unlockRead(stamp);
			}
		}
		return Math.sqrt(currentX * currentX + currentY * currentY);
	}

	public static void main(String[] args) {
		Point point = new Point(2, 3);
		System.out.println(point.distanceFromOrigin());

		point.move(4, 5);
		System.out.println(point.distanceFromOrigin());
	}
}
