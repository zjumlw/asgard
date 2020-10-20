package com.will.asgard.loki.model.concurrency.chapter5;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-21 12:14 上午
 * @Version 1.0
 */
public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                indexFile(queue.take());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void indexFile(File file) {
        // todo 对文件建立索引
    }
}
