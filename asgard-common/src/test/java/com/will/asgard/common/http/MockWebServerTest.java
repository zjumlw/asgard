package com.will.asgard.common.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author willmao
 * Created on 2025/9/4 22:20
 **/
public class MockWebServerTest {

    final MockWebServer server = new MockWebServer();
    final OkHttpClient client = new OkHttpClient();

    @Test
    public void test() throws IOException {
        String body = "{'id':'1'}";
        server.enqueue(new MockResponse()
                .setBody(body)
                .addHeader("Content-Type", "application/json"));
        server.start();

        Request request = new Request.Builder()
                .url(server.url("/"))
                .header("User-Agent", "MockWebServerTest")
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();

        System.out.println(response.code());
        Assert.assertEquals(200, response.code());
        System.out.println(response.isSuccessful());
        Assert.assertTrue(response.isSuccessful());
        System.out.println(response.header("Content-Type"));
        Assert.assertEquals("application/json", response.header("Content-Type"));
        System.out.println(response.body().string());
    }
}
