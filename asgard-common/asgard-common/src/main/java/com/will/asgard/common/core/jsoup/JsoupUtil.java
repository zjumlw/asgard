package com.will.asgard.common.core.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;

/**
 * Created by WillMao on 19-5-28
 */
public class JsoupUtil {

	private JsoupUtil() {
		throw new IllegalStateException("Util class");
	}

	public static Document getDocumentByUrl(String url) throws IOException {
		Preconditions.checkNotNull(url);
		return Jsoup.connect(url).get();
	}

	public static Document getDocumentByHtml(String htmlContent) {
		Preconditions.checkNotNull(htmlContent);
		return Jsoup.parse(htmlContent);
	}

	public static Document getDocumentByFilePath(String filePath) throws IOException {
		Preconditions.checkNotNull(filePath);
		return getDocumentByFile(new File(filePath));
	}

	public static Document getDocumentByFile(File file) throws IOException {
		Preconditions.checkNotNull(file);
		return Jsoup.parse(file, Charsets.UTF_8.name());
	}
}
