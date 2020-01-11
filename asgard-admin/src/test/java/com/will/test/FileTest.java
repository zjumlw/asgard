package com.will.test;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTest {
	private static final Logger logger = LoggerFactory.getLogger(FileTest.class);

	private static final String basicPath = "/home/willmao/workspace/mydemo/src/main/resources";
	private static final String filePath = basicPath + File.separator + "books";
	private static final String fileNewPath = filePath + File.separator + "file_new.txt";

	@Test
	public void testFile() {
		File file = new File(filePath);
		logger.info("exists = " + file.exists());
		logger.info("length = " + file.length());
		if (file.isDirectory()) {
			try {
				File fileNew = new File(fileNewPath);
				if (!fileNew.exists()) {
					logger.info("creating new file {}", fileNewPath);
					fileNew.createNewFile();
				} else {
					logger.info("file exists, file length = {}", fileNew.length());
					logger.info("deleting");
					fileNew.delete();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			File[] files = file.listFiles();
			if (files == null) {
				logger.error("files is null");
				return;
			}

			for (File f : files) {
				logger.info(f.toString());
			}
		}
	}

	@Test
	public void testSeparator() {
		System.out.println("pathSeparator = " + File.pathSeparator);
		System.out.println("separator = " + File.separator);
	}

	@Test
	public void testListAll() {
		File file = new File(basicPath);
		printFile(file);
	}

	private void printFile(File file) {
		if (file == null) {
			return;
		}
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					printFile(f);
				}
			}
		} else {
			System.out.println(file);
		}
	}
}
