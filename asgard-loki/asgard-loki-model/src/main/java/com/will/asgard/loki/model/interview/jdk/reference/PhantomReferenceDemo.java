package com.will.asgard.loki.model.interview.jdk.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-13 下午4:12
 * @Version 1.0
 */
public class PhantomReferenceDemo {

    private static final List<byte[]> LIST = new ArrayList<>();
    private static final ReferenceQueue<Apple> rq = new ReferenceQueue<>();

    public static void main(String[] args) throws InterruptedException {
        PhantomReference<Apple> pr = new PhantomReference<>(new Apple(), rq);
        System.out.println(pr.get()); // null，拿不到

        new Thread(() -> {
            // 需要设置jvm参数-Xmx20M
            while (true) {
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(pr.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends Apple> poll = rq.poll();
                if (poll != null) {
                    System.out.println("虚引用对象被回收了" + poll);
                }
            }
        }).start();

        Thread.sleep(500);
    }
}
