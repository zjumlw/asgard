package com.will.asgard.loki.model.interview.jdk.reference;

import java.lang.ref.SoftReference;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-13 下午3:54
 * @Version 1.0
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        SoftReference<byte[]> sr = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(sr.get()); // 获取下数据
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sr.get()); // gc后再次获取，发现还在

        // 新的强饮用，发现内存空间不够了（前提设置了-Xmx20M）
        byte[] a = new byte[1024 * 1024 * 10];
        System.out.println(sr.get()); // null，软引用被gc回收了
    }
}
