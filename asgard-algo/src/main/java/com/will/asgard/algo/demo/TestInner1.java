package com.will.asgard.algo.demo;

/**
 * @Description 内部类的测试
 * @Author maolingwei
 * @Date 2021-05-25 下午4:00
 * @Version 1.0
 */
public class TestInner1 {
    // 内部类可以访问所在类的属性（包括私有属性）
    private int number = 10;

    private class Inner {
        private int number = 100;

        public void print() {
            int number = 200;
            System.out.println("局部参数=" + number);
            System.out.println("内部类参数=" + this.number);
            System.out.println("外部类参数=" + TestInner1.this.number);
        }
    }

    public static void main(String[] args) {
        TestInner1 testInner1 = new TestInner1();
        // 创建内部类对象需要先创建所在类的对象
        TestInner1.Inner inner = testInner1.new Inner();
        inner.print();
    }
}
