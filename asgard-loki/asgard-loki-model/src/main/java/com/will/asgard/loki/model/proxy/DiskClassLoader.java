package com.will.asgard.loki.model.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName DiskClassLoader
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-29 00:01
 * @Version 1.0
 **/
public class DiskClassLoader extends ClassLoader {

	private String mLibPath;

	public DiskClassLoader(String mLibPath) {
		this.mLibPath = mLibPath;
	}


	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		File file = new File(mLibPath, fileName);
		try {
			FileInputStream is = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = 0;
			try {
				while ((len = is.read()) != -1) {
					bos.write(len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			byte[] data = bos.toByteArray();
			is.close();
			bos.close();
			return defineClass(name, data, 0, data.length);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.findClass(name);
	}

	//获取要加载 的class文件名
	private String getFileName(String name) {
		int index = name.lastIndexOf('.');
		if(index == -1){
			return name+".class";
		}else{
			return name.substring(index+1)+".class";
		}
	}

	public static void main(String[] args) throws IOException {
		String classpath = "/home/will/tmp/Test.class";
		File file = new File(classpath);

	}
}
