package com.will.asgard.loki.model.concurrency.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.will.asgard.loki.model.concurrency.ExceptionHandler;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-31 4:54 下午
 * @Version 1.0
 */
public class FutureRenderer {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void renderPage(CharSequence source) {
        final List<ImageInfo> imageInfos = scanForImageInfo(source);
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> ret = new ArrayList<>();
                for (ImageInfo imageInfo : imageInfos) {
                    ret.add(imageInfo.downloadImage());
                }
                return ret;
            }
        };
        Future<List<ImageData>> future = executorService.submit(task);
        renderText(source);
        try {
            List<ImageData> imageData = future.get();
            for (ImageData data : imageData) {
                renderImage(data);
            }
        } catch (InterruptedException e) {
            // 重新设置线程的中断状态
            Thread.currentThread().interrupt();
            // 由于不需要结果，所以取消任务
            future.cancel(true);
        } catch (ExecutionException e) {
            throw ExceptionHandler.launderThrowable(e);
        }
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        // get image infos
        return new ArrayList<>();
    }

    private void renderText(CharSequence source) {
        // render text
    }

    private void renderImage(ImageData data) {
        // render image
    }
}
