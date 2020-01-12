package com.will.asgard.loki.model.net;

import com.will.asgard.common.util.CommonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.concurrent.TimeUnit;


public class HttpClientManager {

    public static void main(String[] args) throws Exception {
        URI uri = new URIBuilder("http://www.baidu.com").build();
        HttpGet httpGet = new HttpGet(uri);

        doTest(getDefaultHttpClient(), httpGet, "defaultHttpClient");
        doTest(createHttpClient(), httpGet, "PoolingHttpClient");
    }

    private static void doTest(CloseableHttpClient httpClient, HttpGet httpGet, String clientName) throws Exception {
        long totalElapsedTime = 0;
        for (int i = 0; i < 10; i++) {
            long startTime = CommonUtil.getCurrentTimestamp();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            long endTime = CommonUtil.getCurrentTimestamp();
            long elapsedTime = endTime - startTime;
            totalElapsedTime += elapsedTime;
            System.out.println(clientName + "-" + i + ", elapsedTime: " + elapsedTime + " ms");

            int code = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);

            response.close();
        }
        httpClient.close();

        System.out.println(clientName + ", totalElapsedTime: " + totalElapsedTime + " ms");


    }

    public static CloseableHttpClient getDefaultHttpClient() {
        // InternalHttpClient
        CloseableHttpClient httpClient = HttpClients.custom().build();

        return httpClient;
    }

    /**
     * 连接池最多200个连接，每个目标服务器最多持有40个连接，专门设定www.baidu.com:80的目标服务器可以持有最大连接数为80
     * @return
     */
    public static CloseableHttpClient createHttpClient() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(40);

        HttpHost httpHost = new HttpHost("www.baidu.com", 80);
        HttpRoute httpRoute = new HttpRoute(httpHost);
        connectionManager.setMaxPerRoute(httpRoute, 80);

        HttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(5, false);

        // 连接配置
        RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(1000)
            .setConnectTimeout(1000)
            .setSocketTimeout(1000)
            .build();

        return HttpClients.custom()
            .setDefaultRequestConfig(defaultRequestConfig)
            .evictExpiredConnections()
            .evictIdleConnections(10, TimeUnit.SECONDS)
            .setConnectionManager(connectionManager)
            .setRetryHandler(retryHandler)
            .build();
    }
}
