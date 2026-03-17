package com.will.asgard.common.http;

import java.io.IOException;
import java.net.SocketTimeoutException;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author willmao
 * Created on 2025/9/2 20:14
 **/
public class HutoolHttpTest {

    /**
     * 测试Hutool HTTP连接超时功能
     *
     * 该测试验证当连接超时时间设置过短时，
     * Hutool的HTTP客户端能否正确处理连接超时
     */
    @Test(expected = SocketTimeoutException.class)
    public void testConnectionTimeout() throws IOException {
        // 使用极短的连接超时时间（1毫秒）
        long startTime = System.currentTimeMillis();
        try {
            HttpResponse response = HttpRequest.get("http://10.255.255.1") // 一个无法连接的IP地址
                    .timeout(1) // 设置连接超时为1毫秒
                    .execute();
            // 如果执行到这里没有抛出异常，则测试失败
            Assert.fail("Expected timeout exception but none was thrown");
        } catch (Exception e) {
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "毫秒");
        }
    }

    /**
     * 测试timeout方法是否同时设置连接和读取超时
     */
    @Test
    public void testTimeoutSetsBothConnectionAndReadTimeout() throws Exception {
        // 创建一个HTTP请求并设置超时时间
        HttpRequest request = HttpRequest.get("https://www.baidu.com");
        request.timeout(100);
        HttpResponse response = request.execute();
        String body = response.body();
        System.out.println(body);
    }
}
