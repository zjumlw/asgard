package com.will.asgard.pattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author willmao
 * @date 2022-11-18 19:26
 **/
public class ReverseWordInputTest {

    public static void main(String[] args) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("test.txt");
        if (url == null) {
            System.out.println("url is null");
            return;
        }
        String file = url.getFile();
        int c;
        try {
            byte[] buf = new byte[1024];
            InputStream in = new ReverseWordInputStream(new BufferedInputStream(new FileInputStream(file)));
            int len = in.read(buf, 0, 1024);
            byte[] ans = new byte[len];
            System.arraycopy(buf, 0, ans, 0, len);
            System.out.println(new String(ans));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
