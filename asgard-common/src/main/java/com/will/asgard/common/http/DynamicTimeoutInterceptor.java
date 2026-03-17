package com.will.asgard.common.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author willmao
 * Created on 2025/9/4 11:04
 **/
public class DynamicTimeoutInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        TimeoutTag timeoutTag = request.tag(TimeoutTag.class);

        if (timeoutTag != null) {
            if (timeoutTag.getConnectTimeout() != null) {
                chain = chain.withConnectTimeout(timeoutTag.getConnectTimeout(), TimeUnit.MILLISECONDS);
            }
            if (timeoutTag.getReadTimeout() != null) {
                chain = chain.withReadTimeout(timeoutTag.getReadTimeout(), TimeUnit.MILLISECONDS);
            }
            if (timeoutTag.getWriteTimeout() != null) {
                chain = chain.withWriteTimeout(timeoutTag.getWriteTimeout(), TimeUnit.MILLISECONDS);
            }
        }

        return chain.proceed(request);
    }
}
