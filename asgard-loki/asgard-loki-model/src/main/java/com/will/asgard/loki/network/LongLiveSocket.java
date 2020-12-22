package com.will.asgard.loki.network;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-12-05 下午5:38
 * @Version 1.0
 */
public class LongLiveSocket {

    // 错误回调
    interface ErrorCallback {
        boolean onError();
    }

    // 读数据回调
    interface DataCallback {
        void onData(byte[] data, int offset, int len);
    }

    interface WritingCallback {
        void onSuccess();
        void onFail(byte[] data, int offset, int len);
    }

    
}
