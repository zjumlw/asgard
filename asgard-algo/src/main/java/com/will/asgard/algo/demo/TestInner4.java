package com.will.asgard.algo.demo;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-25 下午4:13
 * @Version 1.0
 */
public class TestInner4 {

    private class Inner {
        // 内部类中不能定义static元素
//        private static int number = 10;
        private String name = "ZJ";

        // 内部类可以不断嵌套
        private class InnerOfInner {
            private String name = "SX";
        }
    }

    public static void main(String[] args) {
        TestInner4 testInner4 = new TestInner4();
        TestInner4.Inner inner = testInner4.new Inner();
        System.out.println("inner name=" + inner.name);

        TestInner4.Inner.InnerOfInner innerOfInner = inner.new InnerOfInner();
        System.out.println("innerOfInner name=" + innerOfInner.name);
    }
}
