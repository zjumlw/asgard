package com.will.asgard.algo.demo;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-05-25 下午4:10
 * @Version 1.0
 */
public class TestInner3 {

    private class Car {
        public void print() {
            System.out.println("I am a car");
        }
    }

    private class Inner {
        private Car getMyCar() {
            // 在方法体内可以定义一个内部类，可以完成一个基于虚方法形式的回调操作
            class BMW extends Car {
                @Override
                public void print() {
                    System.out.println("I am a BMW");
                }
            }

            return new BMW();
        }
    }

    public static void main(String[] args) {
        TestInner3 testInner3 = new TestInner3();
        TestInner3.Inner inner = testInner3.new Inner();
        Car myCar = inner.getMyCar();
        myCar.print();
    }
}
