package com.will.asgard.loki.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.hutool.core.io.FileUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.core.io.ClassPathResource;

/**
 * Ainvest Web Html Extract Service
 *
 * @author willmao
 * Created on 2025/5/23 14:22
 **/
public class AinvestWebHtmlExtractService {

    private static final String PROJECT_ROOT = System.getProperty("user.dir");

    private static final String RESOURCES_DIR = "/asgard-loki/asgard-loki-service/src/main/resources/html/";

    public static void main(String[] args) throws IOException {
        System.out.println(PROJECT_ROOT);
        String htmlFileName = "home_page.html";
        processHtml(htmlFileName);
    }

    private static void processHtml(String htmlFileName) throws IOException {
        long start = System.currentTimeMillis();
        Document document = extractHtmlDoc(htmlFileName);
        String text = document.text();
        long end = System.currentTimeMillis();
        System.out.println(String.format("extract html [%s] took %d ms", htmlFileName, (end - start)));

        int words = countWords(text);
        System.out.println("word num is: " + words);

        int tokens = estimateTokenCount(text);
        System.out.println("token num is: " + tokens);

        writeContentToFile(document.html(), "output_" + htmlFileName);
        String textFilePath = "output_" + htmlFileName.replace("html", "txt");
        writeContentToFile(text, textFilePath);
    }

    private static Document extractHtmlDoc(String htmlFileName) throws IOException {
        String htmlFilePath = "html/" + htmlFileName;
        ClassPathResource resource = new ClassPathResource(htmlFilePath);
        File file = resource.getFile();
        Document document = Jsoup.parse(file, "utf-8");
        System.out.println(String.format("Before clean, [%s] element size: %d ", htmlFileName, document.getAllElements().size()));
        removeSpecificDivs(document);
        removeUnwantedElements(document);
        System.out.println(String.format("After clean, [%s] element size: %d", htmlFileName, document.getAllElements().size()));
        return document;
    }

    private static void removeSpecificDivs(Document doc) {
        // 移除特定ID的DIV
        String[] divIdsToRemove = {
                "nav_item_brokers",
                "googleButton",
                "monica-content-root",
                "immersive-translate-browser-popup",
                "hkv_root"
        };

        for (String id : divIdsToRemove) {
            doc.select("div#" + id).remove();
        }
    }

    private static void removeUnwantedElements(Document doc) {
        // 原始清理逻辑保持不变
        String[] tagsToRemove = {
                "head", "script", "style",
                "noscript", "iframe", "link",
                "meta", "svg", "img"
        };

        for (String tag : tagsToRemove) {
            doc.select(tag).remove();
        }

        doc.select("*").forEach(node -> {
            node.html(node.html().replaceAll("<!--.*?-->", ""));
        });
    }


    private static void writeContentToFile(String content, String fileName) throws IOException {
        String dirPath = PROJECT_ROOT + RESOURCES_DIR;
        System.out.println(dirPath);
        File outputDir = new File(dirPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }
        File outputFile = new File(outputDir, fileName);
        FileUtil.writeString(content, outputFile, Charset.defaultCharset());
        System.out.println(String.format("Write output file [%s] successfully", fileName));
    }

    // 英文：1 token ≈ 4字符
    // 中文：1 token ≈ 1.5字符
    public static int estimateTokenCount(String text) {
        int chineseChars = text.replaceAll("[^\\u4e00-\\u9fa5]", "").length();
        int otherChars = text.length() - chineseChars;
        return (int) Math.ceil(chineseChars * 1.5 + otherChars / 4.0);
    }

    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        // 使用正则表达式匹配单词：由字母、数字和下划线组成，忽略标点符号
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);

        int wordCount = 0;
        while (matcher.find()) {
            wordCount++;
        }

        return wordCount;
    }
}
