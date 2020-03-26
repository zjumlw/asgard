package com.will.asgard.loki.model.http.apache.chapter1;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.message.BasicHttpResponse;
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SimpleExample
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-03-25 19:08
 * @Version 1.0
 **/
public class SimpleExample {

	public static void main(String[] args) throws IOException {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
				HttpStatus.SC_OK, "OK");
		response.addHeader("Set-Cookie",
				"c1=a; path=/; domain=localhost");
		response.addHeader("Set-Cookie",
				"c2=b; path=\"/\", c3=c; domain=\"localhost\"");
		Header h1 = response.getFirstHeader("Set-Cookie");
		System.out.println(h1);
		Header h2 = response.getLastHeader("Set-Cookie");
		System.out.println(h2);
		Header[] hs = response.getHeaders("Set-Cookie");
		System.out.println(hs.length);


		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://prod.api.xiaomi.cn/hello/test");
		CloseableHttpResponse resp = httpclient.execute(httpget);
		try {
			String entityString = EntityUtils.toString(resp.getEntity());
			System.out.println(entityString);
		} finally {
			resp.close();
		}
	}
}
