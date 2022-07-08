package com.will.asgard.algo.demo.innerclass;

/**
 * @Description 私有内部类
 * @Author zjumlw
 * @Date 2021-05-25 下午4:00
 * @Version 1.0
 */
public class TestInner1 {
    // 内部类可以访问外部类的属性（包括私有属性）
    private int number = 10;

    // 私有内部类
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
        TestInner1.Inner inner = new TestInner1().new Inner();
        inner.print();
    }
}
