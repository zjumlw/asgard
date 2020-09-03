package com.will.asgard.loki.model.concurrency.chapter3;

import java.awt.*;
import java.util.EventListener;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-02 11:39 下午
 * @Version 1.0
 */
public class SafeListener {
    private final EventListener listener;

    private SafeListener() {
        listener = new EventListener() {
            public void onEvent(Event event) {
                // do something
            }
        };
    }

    public static SafeListener newInstance(EventSource source) {
        SafeListener safe = new SafeListener();
        source.registerListener(safe.listener);
        return safe;
    }

    private static class EventSource {
        private void registerListener(EventListener listener) {
            // register
            System.out.println("register listener");
        }
    }
}
