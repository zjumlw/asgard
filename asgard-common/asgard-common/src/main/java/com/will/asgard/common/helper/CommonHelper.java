package com.will.asgard.common.helper;

import com.will.asgard.common.util.CommonUtil;
import com.will.asgard.common.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class CommonHelper {
    private CommonHelper() {
        throw new IllegalStateException();
    }

    private static final long PERF_INFO_TIME = 100L;
    private static final long PERF_WARN_TIME = 500L;
    private static final String PERF_LOG_STR = "execute perf: {} took {} ms.";

    public static <T> T executeWithPerf(String action, Supplier<T> supplier) {
        long start = CommonUtil.getCurrentTimestamp();
        try {
            return supplier.get();

        } finally {
            // 排查潜在的性能问题，即使发生异常也应该有日志
            long current = CommonUtil.getCurrentTimestamp();
            long interval = current - start;

            if (interval < PERF_INFO_TIME) {
                log.debug(PERF_LOG_STR, action, interval);
            } else if (interval < PERF_WARN_TIME) {
                log.info(PERF_LOG_STR, action, interval);
            } else {
                log.warn(PERF_LOG_STR, action, interval);
            }
        }
    }

    public static <T> T executeWithLog(String action, Supplier<T> supplier) {
        T result = CommonHelper.executeWithPerf(action, supplier);
        // 记录调试日志
        log.debug(action + ": " + toString(result));

        return result;
    }

    private static String toString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return GsonUtil.toJson(obj);
    }
}
