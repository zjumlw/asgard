package com.will.asgard.algo.algs4.chapter1;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @ClassName StdDrawDemo
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-26 17:19
 * @Version 1.0
 **/
public class StdDrawDemo {
	public static void main(String[] args) {
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N * N);
		StdDraw.setPenRadius(0.01);
		for (int i = 1; i <= N; i++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i * i);
			StdDraw.point(i, i * Math.log(i));
		}
	}
}
