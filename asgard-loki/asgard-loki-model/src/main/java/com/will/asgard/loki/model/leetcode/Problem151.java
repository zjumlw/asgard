package com.will.asgard.loki.model.leetcode;

/**
 * @ClassName Problem151
 * @Description 给定一个字符串，逐个翻转字符串中的每个单词。
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author maolingwei
 * @Date 2020-04-14 22:52
 * @Version 1.0
 **/
public class Problem151 {

	public String reverseWords(String s) {
		int length = s.length();
		char[] chars = s.toCharArray();
		String[] words = new String[length];
		int wordsIndex = 0;

		int wordStartIndex = -1;
		int wordEndIndex = -1;
		for (int i = 0; i < length; i++) {
			if (chars[i] != ' ' && wordStartIndex == -1) {
				wordStartIndex = i;
			}
			if (chars[i] == ' ' && wordStartIndex != -1) {
				wordEndIndex = i;
			}
			if (wordStartIndex != -1 && wordEndIndex != -1) {
				String word = s.substring(wordStartIndex, wordEndIndex);
				words[wordsIndex++] = word;
				wordStartIndex = -1;
				wordEndIndex = -1;
			}
		}
		if (wordStartIndex != -1 && wordStartIndex < length) {
			words[wordsIndex++] = s.substring(wordStartIndex);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = wordsIndex - 1; i >= 0; i--) {
			if (sb.length() != 0) {
				sb.append(" ");
			}
			sb.append(words[i]);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = " the sky is blue";
		String[] words = str.trim().split(" +");
		StringBuilder sb = new StringBuilder();
		for(int i=words.length-1 ; i>=0 ; i--){
			sb.append(words[i]+" ");
		}
		System.out.println(sb.toString());
	}
}
