package com.will.asgard.loki.model.concurrency.chapter7;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.concurrent.GuardedBy;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-11-26 上午12:07
 * @Version 1.0
 */
public abstract class WebCrawler {

    private final int TIMEOUT = 5;
    private final TimeUnit UNIT = TimeUnit.SECONDS;

    private volatile TrackingExecutor exec;
    @GuardedBy("this")
    private final Set<URL> urlsToCrawl = new HashSet<>();

    public synchronized void start() {
        exec = new TrackingExecutor(Executors.newCachedThreadPool());
        for (URL url : urlsToCrawl) {
            submitCrawlTask(url);
        }
        urlsToCrawl.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUncrawled(exec.shutdownNow());
            if (exec.awaitTermination(TIMEOUT, UNIT)) {
                saveUncrawled(exec.getCancelledTasks());
            }
        } finally {
            exec = null;
        }
    }

    private void saveUncrawled(List<Runnable> uncrawled) {
        for (Runnable task : uncrawled) {
            urlsToCrawl.add(((CrawlTask) task).getPage());
        }
    }

    private void submitCrawlTask(URL url) {
        exec.execute(new CrawlTask(url));
    }

    protected abstract List<URL> processPage(URL url);

    private class CrawlTask implements Runnable {
        private final URL url;

        public CrawlTask(URL url) {
            this.url = url;
        }

        @Override
        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                submitCrawlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}
