package com.will.asgard.loki.model.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName EncripyUtil
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-29 00:26
 * @Version 1.0
 **/
public class FileUtils {

	public static void encryptFile(String path) {
		File file = new File(path);
		try (FileInputStream is = new FileInputStream(file);
			 FileOutputStream os = new FileOutputStream(path + "en")) {
			int b = 0;
			int b1 = 0;
			while ((b = is.read()) != -1) {
				os.write(b ^ 2);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
