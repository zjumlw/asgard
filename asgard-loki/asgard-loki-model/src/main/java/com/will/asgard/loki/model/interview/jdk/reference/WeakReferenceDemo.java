package com.will.asgard.loki.model.interview.jdk.reference;

import java.lang.ref.WeakReference;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-03-13 下午4:06
 * @Version 1.0
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        WeakReference<Apple> w = new WeakReference<Apple>(new Apple());
        System.out.println(w.get());
        System.gc();
        System.out.println(w.get());
    }
}
