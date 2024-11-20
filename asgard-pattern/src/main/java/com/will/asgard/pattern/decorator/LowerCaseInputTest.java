package com.will.asgard.pattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author willmao
 * @date 2022-11-18 01:17
 **/
public class LowerCaseInputTest {

    public static void main(String[] args) {
        int c;
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("test.txt");
            String file = url.getFile();
//            System.out.println("url=" + url);
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(file)));
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
