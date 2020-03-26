package com.will.asgard.loki.model.http.apache.chapter1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Test;

public class SimpleExampleTest {

	@Test
	public void testUriBuilder() throws URISyntaxException, IOException {
		URI uri = new URIBuilder()
				.setScheme("https")
				.setHost("www.baidu.com")
				.setPath("/s")
				.setParameter("wd", "httpclient")
				.build();
		HttpGet httpget = new HttpGet(uri);
		System.out.println(httpget.getURI());

		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse resp = httpclient.execute(httpget);
		System.out.println(resp.getProtocolVersion());
		System.out.println(resp.getStatusLine().getStatusCode());
		System.out.println(resp.getStatusLine().getReasonPhrase());
		System.out.println(resp.getStatusLine().toString());
	}

	@Test
	public void testResponseHeaders() {
		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
				HttpStatus.SC_OK, "OK");
		response.addHeader("Set-Cookie",
				"c1=a; path=/; domain=localhost");
		response.addHeader("Set-Cookie",
				"c2=b; path=\"/\", c3=c; domain=\"localhost\"");

		HeaderElementIterator it = new BasicHeaderElementIterator(
				response.headerIterator("Set-Cookie"));

		while (it.hasNext()) {
			HeaderElement elem = it.nextElement();
			System.out.println(elem.getName() + " = " + elem.getValue());
			NameValuePair[] params = elem.getParameters();
			System.out.println(params.length);
			for (int i = 0; i < params.length; i++) {
				System.out.println(" " + params[i]);
			}
		}
	}
}