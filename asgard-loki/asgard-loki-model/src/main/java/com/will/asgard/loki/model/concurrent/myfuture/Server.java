package com.will.asgard.loki.model.concurrent.myfuture;

/**
 * @ClassName Server
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-08-28 17:27
 * @Version 1.0
 **/
public class Server {

    public FutureData<String> getString() {
        final FutureData<String> futureData = new FutureData<>();
        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            futureData.setData("tom");
        }).start();
        return futureData;
    }
}
