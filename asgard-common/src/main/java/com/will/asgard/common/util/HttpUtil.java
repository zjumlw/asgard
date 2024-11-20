package com.will.asgard.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.framed.Header;

/**
 * @Description TODO
 * @Author zjumlw
 * @Date 2021-09-10 10:19 下午
 * @Version 1.0
 **/
public class HttpUtil {

    private static OkHttpClient client = new OkHttpClient();

    public static String httpGet(String url, Headers headers) {
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String httpGet(String url, Map<String, String> headers) {
        Headers headers1 = Headers.of(headers);
        return httpGet(url, headers1);
    }

    public static void main(String[] args) {
        String url = "http://www.cwl.gov.cn/cwl_admin/kjxx/findDrawNotice?name=ssq&dayStart=2021-01-01&dayEnd=2021-01-20";
        Headers headers = new Headers.Builder().add("Referer", "http://www.cwl.gov.cn")
                .build();
        String resp = httpGet(url, headers);
        System.out.println(resp);
    }
}
