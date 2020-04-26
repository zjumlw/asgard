package com.will.asgard.loki.model.interview;

/**
 * @ClassName StrReplace
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-24 15:36
 * @Version 1.0
 **/
public class StrReplace {

	public static String solution(String origin, char[] strs) {
		int pointer = 0;
		int length = strs.length;
		String tmp = origin;

		while (tmp.contains("%s") && pointer < length) {
			tmp = tmp.replaceFirst("%s", String.valueOf(strs[pointer++]));
		}
		StringBuilder sb = new StringBuilder(tmp);
		while (pointer < length) {
			sb.append(strs[pointer++]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String origin = "a%sb%%sc%s";
		char[] chars = new char[]{'a', 'c'};
		System.out.println(solution(origin, chars));
	}
}
