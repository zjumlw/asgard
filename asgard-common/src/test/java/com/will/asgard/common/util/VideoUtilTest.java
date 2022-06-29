package com.will.asgard.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.hutool.core.io.FileUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author willmao
 * @date 2022-06-17 11:46 PM
 **/
public class VideoUtilTest {

    private static final int SHORT_VIDEO_DURATION = 60 * 4;
    private final List<String> years = new ArrayList<>();
    private final String[] yearSeparator = new String[]{"-", "/", "_"};

    @Before
    public void before() {
        for (int i = 2010; i <= 2022; i++) {
            years.add("" + i);
        }
    }

    @Test
    public void testRemoveShortVideos() {
        String rootDir = "/Volumes/TOSHIBA EXT/娱乐/videos/Domestic";
        String fileName = "用大吊各种姿势抽插征服女神.rmvb";
        String filePath = rootDir + "/" + fileName;
        File file = FileUtil.file(filePath);
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        long videoDuration = VideoUtil.getVideoDuration(file);
        System.out.println(videoDuration);
    }

    @Test
    public void removeFiles() {
        String dir = "/Volumes/TOSHIBA EXT/娱乐/videos";
        File rootDir = FileUtil.file(dir);
        String[] videoType = new String[]{".mp4", ".mkv", ".rmvb", ".avi", ".MOV", ".MP4", ".wmv", ".TS", ".ts", ".webm", ".mpg"};
        String[] deleteSuffix = new String[]{".mht", ".torrent", ".apk", ".htm", ".html", ".url", ".URL", ".lnk", ".js",
                ".rtf", ".chm", "网址.png", "发布器.png"};
        String[] interestedFileType = new String[]{"._LAFBD-63", "._LAFBD-41", ".xltd", "._LAFBD-47", "._LAFBD-23", ".cfg"};


        List<File> files = FileUtil.loopFiles(rootDir, 6, null);
        Set<String> suffix = new HashSet<>();
        Set<File> hiddenFiles = new HashSet<>();
        Set<File> emptyDirs = new HashSet<>();
        Set<File> deleteFiles = new HashSet<>();
        Set<File> shortVideos = new HashSet<>();
        Set<File> noSuffixFiles = new HashSet<>();
        Set<File> interestedFiles = new HashSet<>();
        Map<File, String> renameFiles = new HashMap<>();

        for (File file : files) {
            try {
                if (Files.isHidden(file.toPath())) {
                    hiddenFiles.add(file);
                }
                if (file.isDirectory() && FileUtil.isDirEmpty(file)) {
                    emptyDirs.add(file);
                }
                String name = file.getName();
                for (String delSuffix : deleteSuffix) {
                    if (name.endsWith(delSuffix)) {
                        deleteFiles.add(file);
                    }
                }

                for (String s : videoType) {
                    if (name.endsWith(s) && !name.startsWith("._")) {
                        long duration = VideoUtil.getVideoDuration(file);
                        if (duration < SHORT_VIDEO_DURATION) {
                            shortVideos.add(file);
                        }
                    }
                }
                if (file.isFile()) {
                    String[] split = name.split("\\.");
                    if (split.length >= 2) {
                        String suffixType = "." + split[split.length - 1];
                        suffix.add(suffixType);
                    } else {
                        noSuffixFiles.add(file);
                    }
                }

                for (String type : interestedFileType) {
                    if (name.endsWith(type)) {
                        interestedFiles.add(file);
                    }
                }

                String replaceName = name.replace(" ", "");
                if (!name.endsWith(replaceName)) {
                    renameFiles.put(file, replaceName);
                }

//                for (String year : years) {
//                    for (String separator : yearSeparator) {
//                        String key = year + separator;
//                        if (name.contains(key)) {
//                            int index = name.indexOf(key);
//                            if (index > 0) {
//                                String newName = name.replace(key, " " + key);
//                                renameFiles.put(file, newName);
//                            }
//                        }
//                    }
//                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("files size: " + files.size());
        System.out.println("suffix: " + suffix);

        hiddenFiles.forEach(file -> {
            System.out.println("del hidden file: " + file.getAbsolutePath());
            FileUtil.del(file);
        });

        emptyDirs.forEach(file -> {
            System.out.println("del empty dir: " + file.getAbsolutePath());
            FileUtil.del(file);
        });

        deleteFiles.forEach(file -> {
            System.out.println("del not need file: " + file.getAbsolutePath());
            FileUtil.del(file);
        });

        interestedFiles.forEach(file -> {
            System.out.println("interested file: " + file.getAbsolutePath());
//            FileUtil.del(file);
        });

        System.out.println("short videos size: " + shortVideos.size());
        shortVideos.forEach(file -> {
            System.out.println("del short video file: " + file.getAbsolutePath());
            FileUtil.del(file);
        });

        noSuffixFiles.forEach(file -> {
            System.out.println("no suffix file: " + file.getAbsolutePath());
        });

        for (Map.Entry<File, String> e : renameFiles.entrySet()) {
            File file = e.getKey();
            if (file != null && file.exists()) {
                String replaceName = e.getValue();
                System.out.println("rename file: " + file.getAbsolutePath() + ", new name: " + replaceName);
//                FileUtil.rename(file, replaceName, true);
            }
        }
    }

    @Test
    public void testFileSuffix() {
        String fileName = "91大神巨作-大型超市老板千金96年172白富美女神宝儿捆绑喷潮喊：干我,不要了,再不射要把我玩坏了!高清无水印版!.mp4";
        String[] split = fileName.split("\\.");
        System.out.println(split.length);
    }

    @Test
    public void testRename() {
        String name = "242018-06-14BritneyXCamguy2_mobile.jpeg";
        for (String year : years) {
            for (String separator : yearSeparator) {
                String key = year + separator;
                if (name.contains(key)) {
                    int index = name.indexOf(key);
                    System.out.println(index);
                    if (index > 0) {
                        String newName = name.replace(key, " " + key);
                        System.out.println(newName);
                    }
                }
            }
        }
    }
}