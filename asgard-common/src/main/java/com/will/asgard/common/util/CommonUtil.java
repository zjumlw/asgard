package com.will.asgard.common.util;

public class CommonUtil {

    private CommonUtil() {
        throw new IllegalStateException();
    }

    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    public static int safeParseInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }
}
