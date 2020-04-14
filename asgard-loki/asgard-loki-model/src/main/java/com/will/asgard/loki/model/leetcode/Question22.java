package com.will.asgard.loki.model.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * @ClassName Problem22
 * @Description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @Author maolingwei
 * @Date 2020-04-09 22:00
 * @Version 1.0
 **/
public class Question22 {

	private static final String LEFT = "(";
	private static final String RIGHT = ")";

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0) {
			return result;
		}
		dfs("", n, n, result);
		return result;
	}

	private void dfs(String curStr, int left, int right, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(curStr);
		}

		if (left > right) {
			return;
		}

		if (left > 0) {
			dfs(curStr + LEFT, left - 1, right, res);
		}

		if (right > 0) {
			dfs(curStr + RIGHT, left, right - 1, res);
		}
	}

	public List<String> generateParenthesis2(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}

		List<List<String>> dp = new ArrayList<>();
		List<String> dp0 = new ArrayList<>();
		dp0.add("");
		dp.add(dp0);

		for (int i = 1; i <= n; i++) {
			List<String> cur = new ArrayList<>();
			for (int j = 0; j <= i - 1; j++) {
				List<String> str1 = dp.get(j);
				List<String> str2 = dp.get(i - j - 1);
				for (String s1 : str1) {
					for (String s2 : str2) {
						cur.add("(" + s1 + ")" + s2);
					}
				}
			}
			dp.add(cur);
		}

		return dp.get(n);
	}

	public static void main(String[] args) {
		int n = 3;
		List<String> result = new Question22().generateParenthesis(n);
		System.out.println(new Gson().toJson(result));

//		System.out.println(new Problem22().getWithLeftAndRight(3, 3).substring(2));
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(5);
	}
}
