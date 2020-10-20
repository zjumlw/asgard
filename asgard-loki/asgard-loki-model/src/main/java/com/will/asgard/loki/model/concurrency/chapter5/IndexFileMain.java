package com.will.asgard.loki.model.concurrency.chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-21 12:26 上午
 * @Version 1.0
 */
public class IndexFileMain {
    private static final int BOUND = 10;
    private static final int N_CONSUMER = 5;

    public static void main(String[] args) {
        File[] roots = new File[10];
        BlockingQueue<File> queue = new LinkedBlockingDeque<>(BOUND);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        for (File root : roots) {
            if (root != null) {
                new Thread(new FileCrawler(queue, fileFilter, root)).start();
            }
        }

        for (int i = 0; i < N_CONSUMER; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }
}
