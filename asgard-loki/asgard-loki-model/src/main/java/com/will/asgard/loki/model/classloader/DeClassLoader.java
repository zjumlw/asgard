package com.will.asgard.loki.model.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName DeClassLoader
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-29 00:30
 * @Version 1.0
 **/
public class DeClassLoader extends ClassLoader {

	private String mLibPath;

	public DeClassLoader(String mLibPath) {
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
					bos.write(len ^ 2);
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
			return name+".classen";
		}else{
			return name.substring(index+1)+".classen";
		}
	}
}
