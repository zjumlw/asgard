package com.will.asgard.algo.demo;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-25 下午4:07
 * @Version 1.0
 */
public class TestInner2 {

    // 可以定义内部接口
    private interface Fly {
        void doFly();
    }

    // 可以由内部类实现内部接口
    private class Inner implements Fly {

        @Override
        public void doFly() {
            System.out.println("I can fly");
        }
    }

    public static void main(String[] args) {
        TestInner2 testInner2 = new TestInner2();
        TestInner2.Fly inner = testInner2.new Inner();
        inner.doFly();
    }
}
