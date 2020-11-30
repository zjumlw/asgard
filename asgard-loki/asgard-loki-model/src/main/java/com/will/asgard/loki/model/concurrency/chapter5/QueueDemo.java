package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-11-27 11:56
 * @Version 1.0
 **/
public class QueueDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(String.valueOf((char) (i + 'a')));
        }
        System.out.println(queue);
        boolean b2 = queue.offer(null);
        System.out.println(b2);

        System.out.println(queue);
    }
}
