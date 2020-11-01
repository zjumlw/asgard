package com.will.asgard.loki.model.concurrency;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-31 8:21 下午
 * @Version 1.0
 */
public class ExceptionHandler {

    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw  (Error) t;
        } else {
            throw new IllegalStateException("Not unchecked", t);
        }
    }
}
