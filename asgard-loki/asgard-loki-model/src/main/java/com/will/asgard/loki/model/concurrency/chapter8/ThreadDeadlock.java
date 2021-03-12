package com.will.asgard.loki.model.concurrency.chapter8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-26 下午9:32
 * @Version 1.0
 */
public class ThreadDeadlock {
    // 会死锁
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    // 可以执行
//    private ExecutorService exec = Executors.newCachedThreadPool();

    private void execute() throws Exception {
        RenderPageTask task = new RenderPageTask();
        Future<String> ans = exec.submit(task);
        System.out.println("ans: " + ans.get());
    }

    private class RenderPageTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html"));
            footer = exec.submit(new LoadFileTask("footer.html"));
            String page = renderPage();
            return header.get() + page + footer.get();
        }
    }

    private String renderPage() {
        return " page ";
    }

    private class LoadFileTask implements Callable<String> {

        private String file;

        public LoadFileTask(String file) {
            this.file = file;
        }

        @Override
        public String call() throws Exception {
            return file;
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadDeadlock threadDeadlock = new ThreadDeadlock();
        threadDeadlock.execute();
    }
}
