package com.will.asgard.common.http;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author willmao
 * Created on 2025/9/2 17:25
 **/
public class OkHttpTest {

    /**
     * 测试 okhttp 的基本用法
     */
    @Test
    public void simpleTest() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Dispatcher dispatcher = okHttpClient.dispatcher();
        int maxRequests = dispatcher.getMaxRequests();
        Assert.assertEquals(64, maxRequests);
        int maxRequestsPerHost = dispatcher.getMaxRequestsPerHost();
        Assert.assertEquals(5, maxRequestsPerHost);

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
    }

    /**
     * 测试 okhttp 连接超时功能
     * 该测试验证当连接超时时间设置过短时，客户端是否正确抛出 SocketTimeoutException
     *
     * @throws IOException 测试过程中可能抛出的 IOException
     */
    @Test(expected = SocketTimeoutException.class)
    public void test() throws IOException {
        // 创建一个连接超时时间极短的 client
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(100, TimeUnit.MILLISECONDS)
                .build();
        // 建一个指向不存在服务器的请求
        Request request = new Request.Builder()
                .url("http://10.0.56.101")
                .build();
        // 执行请求，应该抛出 SocketTimeoutException
        long startTime = System.currentTimeMillis();
        try {
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("请求耗时：" + (endTime - startTime) + "ms");
        }

        // 如果执行到这里没有抛出异常，则测试失败
        Assert.fail("Expected SocketTimeoutException but none was thrown");
    }

    /**
     * 测试正常的连接超时设置
     * 该测试验证合理的连接超时时间设置是否正常工作
     */
    @Test
    public void testNormalConnectionTimeout() {
        // 创建一个正常的OkHttpClient连接超时设置（5秒）
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        // 验证连接超时时间设置是否正确
        Assert.assertEquals(5000, client.connectTimeoutMillis());
    }

    /**
     * 测试带有标签的请求
     */
    @Test
    public void testRequestWithTag() throws IOException {
        MockWebServer server = new MockWebServer();
        server.start();
        server.enqueue(new MockResponse()
                .setBody("Hello World")
                .setBodyDelay(1, TimeUnit.SECONDS)
                .setResponseCode(200));

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new DynamicTimeoutInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(500, TimeUnit.MILLISECONDS)
                .build();
        int connectTimeoutMillis = client.connectTimeoutMillis();
        int readTimeoutMillis = client.readTimeoutMillis();
        Assert.assertEquals(5000, connectTimeoutMillis);
        Assert.assertEquals(500, readTimeoutMillis);

        TimeoutTag timeoutTag = TimeoutTag.builder()
                .connectTimeout(100)
                .readTimeout(200)
                .build();
        Request request = new Request.Builder()
                .url(server.url("/slow"))
                .tag(TimeoutTag.class, timeoutTag)
                .build();
        long start = System.currentTimeMillis();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
            Assert.fail("应该超时");
        } catch (IOException e) {
            long cost = System.currentTimeMillis() - start;
            System.out.println("耗时：" + cost);
            Assert.assertTrue("超时生效，耗时太长: " + cost, cost < 1000);
        } finally {
            server.shutdown();
        }
    }

    @Test
    public void testClientClone() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new DynamicTimeoutInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(500, TimeUnit.MILLISECONDS)
                .build();

        OkHttpClient clone = client.newBuilder().build();
        Assert.assertEquals(client.connectTimeoutMillis(), clone.connectTimeoutMillis());
    }

    @Test
    public void testTcpReuse() throws Exception {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpClient client1 = builder.build();
        OkHttpClient client2 = builder.build();

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        // 第一次请求
        long t1 = System.currentTimeMillis();
        Response response1 = client1.newCall(request).execute();
        long t2 = System.currentTimeMillis();
        System.out.println("第一次请求耗时：" + (t2 - t1));
        response1.close();
        // 第二次请求
        long t3 = System.currentTimeMillis();
        Response response2 = client2.newCall(request).execute();
        long t4 = System.currentTimeMillis();
        System.out.println("第二次请求耗时：" + (t4 - t3));
        response2.close();
    }
}
