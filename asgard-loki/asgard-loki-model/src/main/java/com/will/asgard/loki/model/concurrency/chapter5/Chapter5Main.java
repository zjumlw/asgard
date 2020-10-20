package com.will.asgard.loki.model.concurrency.chapter5;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-20 10:40 下午
 * @Version 1.0
 */
class Chapter5Main {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        int cnt = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (cnt++ == 2) {
                list.remove(4);
            }
            System.out.println(it.next());
        }
    }
}
