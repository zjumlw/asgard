package com.will.asgard.common.util;

public class LoggerUtil {
	public static final int MAX_PMA_SIZE = 100;
	public static final int MAX_PMA_LINE_SIZE = 70;
	public static final int MAX_PMA_TAB_SIZE = 2;
	public static final char ch = '=';

    public static void main(String[] args) {
        String part = "hello world";
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            msg.append(part).append(" ");
        }

        System.out.println(payMeAttention(msg.toString()));
    }

	/**
	 * 让你的日志 魅力十足
	 */
	public static String payMeAttention(String message){
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		for (int i = 0; i < MAX_PMA_SIZE; i++) {
			sb.append(ch);
		}
		sb.append('\n');
		int line = message.length() / MAX_PMA_LINE_SIZE + 1;
		int cost = 0;
		for (int i = 0; i < line; i++) {
			int remain = message.length() - cost;
			if (remain > MAX_PMA_LINE_SIZE){
				remain = MAX_PMA_LINE_SIZE;
			}
			int gap = (MAX_PMA_SIZE - remain) / 2 - MAX_PMA_TAB_SIZE;
			for (int j = 0; j < gap; j++) {
				sb.append(ch);
			}
			for (int j = 0; j < MAX_PMA_TAB_SIZE; j++) {
				sb.append(' ');
			}
			for (int j = cost; j < cost + remain; j++) {
				sb.append(message.charAt(j));
			}
			cost += remain;
			for (int j = 0; j < MAX_PMA_TAB_SIZE; j++) {
				sb.append(' ');
			}
			for (int j = 0; j < MAX_PMA_SIZE - gap - remain - 2 * MAX_PMA_TAB_SIZE; j++) {
				sb.append(ch);
			}
			sb.append('\n');
		}
		for (int i = 0; i < MAX_PMA_SIZE; i++) {
			sb.append(ch);
		}
		sb.append('\n');
		return sb.toString();
	}
}
