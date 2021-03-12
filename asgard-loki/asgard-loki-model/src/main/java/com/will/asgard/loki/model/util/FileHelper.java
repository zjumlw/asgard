package com.will.asgard.loki.model.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-01-21 上午11:28
 * @Version 1.0
 */
@Slf4j
public class FileHelper {

    @SuppressWarnings("unchecked")
    public static <T> void writeFile(String path, List<T> contentList) throws IOException {
        Preconditions.checkNotNull(path);
        Preconditions.checkNotNull(contentList);

        StringBuilder sb = new StringBuilder();
        for (T line : contentList) {
            String lineValue = String.valueOf(line);
            if (sb.length() != 0) {
                sb.append("\r\n");
            }
            sb.append(lineValue);
        }
        writeFile(path, sb.toString());
    }

    @SuppressWarnings("unchecked")
    public static <K, V> void writeFile(String path, Map<K, V> contentMap) throws IOException {
        Preconditions.checkNotNull(path);
        Preconditions.checkNotNull(contentMap);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : contentMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (sb.length() != 0) {
                sb.append("\r\n");
            }
            sb.append(key).append("\t").append(value);
        }
        writeFile(path, sb.toString());
    }

    public static void writeFile(String path, String content) throws IOException {
        Preconditions.checkNotNull(path);
        Preconditions.checkNotNull(content);

        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(content);
        }
        log.info("success writeFile: " + path);
    }
}
