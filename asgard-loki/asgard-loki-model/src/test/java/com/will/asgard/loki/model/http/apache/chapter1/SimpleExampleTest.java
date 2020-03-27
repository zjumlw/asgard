package com.will.asgard.loki.model.http.apache.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import org.apache.http.Consts;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.google.gson.reflect.TypeToken;
import com.will.asgard.common.util.GsonUtil;

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

	@Test
	public void testEntities() throws IOException {
		StringEntity myEntity = new StringEntity("important message",
				ContentType.create("text/plain", "UTF-8"));

		System.out.println(myEntity.getContentType());
		System.out.println(myEntity.getContentLength());
		System.out.println(EntityUtils.toString(myEntity));
		System.out.println(EntityUtils.toByteArray(myEntity).length);
		System.out.println(myEntity.getContentEncoding());

		InputStream is = myEntity.getContent();
	}

	@Test
	public void testHtmlForms() {
		List<NameValuePair> formparams = new ArrayList<>();
		formparams.add(new BasicNameValuePair("param1", "value1"));
		formparams.add(new BasicNameValuePair("param2", "value2"));
		UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

		HttpPost httpPost = new HttpPost("https://www.baidu.com");
		httpPost.setEntity(encodedFormEntity);
	}

	@Test
	public void testResponseHandler() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://prod.api.xiaomi.cn/hello/test");
		ResponseHandler<Map<String,String>> rh = new ResponseHandler<Map<String, String>>() {
			@Override
			public Map<String, String> handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				StatusLine statusLine = response.getStatusLine();
				HttpEntity entity = response.getEntity();
				if (statusLine.getStatusCode() >= 300) {
					throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
				}
				if (entity == null) {
					throw new ClientProtocolException("Response contains no content");
				}
				String content = EntityUtils.toString(entity);
				return GsonUtil.fromJson(content, new TypeToken<Map<String, String>>() {
				}.getType());
			}
		};
		Map<String, String> result = httpClient.execute(httpGet, rh);
		System.out.println(GsonUtil.toJson(result));
	}

	@Test
	public void testStrategy() {
		ConnectionKeepAliveStrategy keepAliveStrategy = new DefaultConnectionKeepAliveStrategy() {
			@Override
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				long keepAlive = super.getKeepAliveDuration(response, context);
				// Keep connections alive 5s if a keep-alive value has not be explicitly set by the server
				if (keepAlive == -1) {
					keepAlive = 5000;
				}
				return keepAlive;
			}
		};
		CloseableHttpClient httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrategy)
				.build();
		HttpContext context = new BasicHttpContext();
		HttpClientContext clientContext = HttpClientContext.adapt(context);
		HttpHost target = clientContext.getTargetHost();
		HttpRequest request = clientContext.getRequest();
		HttpResponse response = clientContext.getResponse();
		RequestConfig config = clientContext.getRequestConfig();
	}


	@Test
	public void testHttpContext() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(1000)
				.setConnectTimeout(100)
				.build();

		HttpGet httpGet = new HttpGet("https://prod.api.xiaomi.cn/hello/test");
		httpGet.setConfig(requestConfig);

		CloseableHttpResponse response = httpClient.execute(httpGet);
		try {
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			System.out.println(content);
		} finally {
			response.close();
		}
	}

	@Test
	public void testRetryHandler() {
		HttpRequestRetryHandler retryHandler = (exception, executionCount, context) -> {
			if (executionCount >= 5) {
				return false;
			}
			if (exception instanceof InterruptedIOException) {
				return false;
			}
			if (exception instanceof UnknownHostException) {
				return false;
			}
			if (exception instanceof ConnectTimeoutException) {
				return false;
			}
			if (exception instanceof SSLException) {
				return false;
			}
			HttpClientContext clientContext = HttpClientContext.adapt(context);
			HttpRequest request = clientContext.getRequest();
			boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
			if (idempotent) {
				return true;
			}
			return false;
		};

		CloseableHttpClient httpClient = HttpClients.custom()
				.setRetryHandler(retryHandler)
				.build();
	}

	@Test
	public void testRedirectHandling() {
		LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setRedirectStrategy(redirectStrategy)
				.build();
	}

	@Test
	public void testRewriteRequest() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpClientContext context = HttpClientContext.create();
		HttpGet httpGet = new HttpGet("https://prod.api.xiaomi.cn/hello");
		CloseableHttpResponse response = httpClient.execute(httpGet, context);
		try {
			HttpHost httpHost = context.getTargetHost();
			System.out.println(httpHost);

			List<URI> redirectLocations = context.getRedirectLocations();
			URI location = URIUtils.resolve(httpGet.getURI(), httpHost, redirectLocations);
			System.out.println("Final HTTP location: " + location.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			response.close();
		}
	}
}