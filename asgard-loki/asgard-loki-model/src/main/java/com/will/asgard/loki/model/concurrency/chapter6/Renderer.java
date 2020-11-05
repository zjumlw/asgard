package com.will.asgard.loki.model.concurrency.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-04 14:30
 * @Version 1.0
 **/
public class Renderer {
    private final ExecutorService executor;

    public Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    public void renderPage(CharSequence source) {
        List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executor);
        for (final ImageInfo imageInfo : info) {
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }


    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        // get image info
        return new ArrayList<>();
    }

    private void renderText(CharSequence source) {
        // render text
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        boolean b = executorService instanceof AbstractExecutorService;
        System.out.println(b);
    }
}
