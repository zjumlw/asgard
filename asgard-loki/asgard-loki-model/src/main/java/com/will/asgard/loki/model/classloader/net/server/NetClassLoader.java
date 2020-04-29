package com.will.asgard.loki.model.classloader.net.server;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @ClassName NetClassLoader
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-30 00:26
 * @Version 1.0
 **/
public class NetClassLoader extends ClassLoader {
	private static final String SERVER_HOST = "localhost";
	private static final int SERVER_PORT = 9999;

	public Class<?> loadData(String className) throws Exception {
		byte[] bytes = loadClassFileDate();
		if (bytes != null) {
			return super.defineClass(className, bytes, 0, bytes.length);
		}
		return null;
	}

	private byte[] loadClassFileDate() throws Exception {
		InputStream inputStream = null;
		ByteArrayOutputStream bos = null;
		try(Socket client = new Socket(SERVER_HOST, SERVER_PORT)) {
			inputStream = client.getInputStream();
			bos = new ByteArrayOutputStream();
			int len = 0;
			while ((len = inputStream.read()) != -1) {
				bos.write(len);
			}
			return bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (bos != null) {
				bos.close();
			}
		}
		return new byte[0];
	}
}
