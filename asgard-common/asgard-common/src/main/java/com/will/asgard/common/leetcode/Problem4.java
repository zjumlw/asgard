package com.will.asgard.common.leetcode;

import com.google.common.collect.Lists;
import com.will.asgard.common.util.GsonUtil;

import java.util.List;

public class Problem4 {

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList();
		list.add("Will");
		list.add("Mao");
		System.out.println(GsonUtil.toJson(list));
	}

	public void solutionForProblem4() {
		System.out.println("OK");
	}
}
