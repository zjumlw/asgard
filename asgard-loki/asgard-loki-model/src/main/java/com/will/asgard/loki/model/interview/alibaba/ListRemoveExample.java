package com.will.asgard.loki.model.interview.alibaba;

import java.util.List;

import org.w3c.dom.ls.LSOutput;

import com.google.common.collect.Lists;
import com.will.asgard.common.util.GsonUtil;

/**
 * @ClassName ListRemoveExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-03 17:04
 * @Version 1.0
 **/
public class ListRemoveExample {

	public static void main(String[] args) {
		List<String> list = Lists.newArrayList();
		// n>2时不管remove哪个都会出错
		int n = 10;
		for (int i = 1; i <= n; i++) {
			list.add("" + i);
		}

		for (String item : list) {
			if ("1".equals(item)) {
				list.remove(item);
			}
		}

		System.out.println(GsonUtil.toJson(list));
	}
}
