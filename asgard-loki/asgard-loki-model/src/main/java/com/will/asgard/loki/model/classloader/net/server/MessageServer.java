package com.will.asgard.loki.model.classloader.net.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName MessageServer
 * @Description 接收客户端请求，返回class文件的字节码数据
 * @Author maolingwei
 * @Date 2020-04-30 00:18
 * @Version 1.0
 **/
public class MessageServer {
	private static final String DIRECTORY = "/home/will/tmp";
	private static final String CLASS_NAME = "Test.class";

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9999);
		System.out.println("start net server, waiting for request...");
		Socket client = serverSocket.accept(); // 进入阻塞状态，等待客户端连接

		String classFilePath = DIRECTORY + File.separator + CLASS_NAME;
		File classFile = new File(classFilePath);
		try(InputStream is = new FileInputStream(classFile)) {
			OutputStream os = client.getOutputStream();
			byte[] b = new byte[200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				os.write(b, 0, len);
			}
		}

		client.shutdownOutput(); // 当前数据响应完成之后关闭连接
		serverSocket.close();
		System.out.println("server closed...");
	}
}
