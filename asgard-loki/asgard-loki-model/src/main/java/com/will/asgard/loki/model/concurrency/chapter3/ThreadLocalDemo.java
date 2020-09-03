package com.will.asgard.loki.model.concurrency.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-09-03 12:19 上午
 * @Version 1.0
 */
public class ThreadLocalDemo {
    private static final String DB_URL = "db_url";
    private static ThreadLocal<Connection> connectionHolder = ThreadLocal.withInitial(() -> {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    });

    public static Connection getConnection() {
        return connectionHolder.get();
    }

    private static ThreadLocal<ThreadContext> threadContextHolder = ThreadLocal.withInitial(() -> {
        ThreadContext threadContext = new ThreadContext();
        String threadName = Thread.currentThread().getName();
        threadContext.setName(threadName);
        return threadContext;
    });

    public static ThreadContext getThreadContext() {
        return threadContextHolder.get();
    }

    @Getter
    @Setter
    private static class ThreadContext {
        private String name;
    }

    public static void main(String[] args) {
        System.out.println("start");
        ThreadContext threadContext1 = getThreadContext();
        System.out.println(threadContext1.getName());

        new Thread(() -> {
            System.out.println(getThreadContext().getName());
        }).start();

        change();
        System.out.println(threadContext1.getName());
    }

    private static void change() {
        ThreadContext threadContext = getThreadContext();
        threadContext.setName("main thread");
    }
}
