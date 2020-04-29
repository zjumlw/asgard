package com.will.asgard.loki.model.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OOMDemo
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-30 01:16
 * @Version 1.0
 **/
public class OOMDemo {

	public static void main(String[] args) {
		System.out.println("OOM");
		List<OOMDemo> list = new ArrayList<>();
		while (true) {
			list.add(new OOMDemo());
		}
	}
}
