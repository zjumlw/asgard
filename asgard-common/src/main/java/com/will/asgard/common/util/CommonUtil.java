package com.will.asgard.common.util;

public class CommonUtil {

    private CommonUtil() {
        throw new IllegalStateException();
    }

    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
}
