package com.will.asgard.loki.model.concurrent.chapter2;

/**
 * @ClassName InterruptExample
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-03-26 23:01
 * @Version 1.0
 **/
public class InterruptExample {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                while (true) {
                    // 看下当前线程是否被中断了
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(threadName + " is interrupted!");
                        boolean b = Thread.currentThread().isInterrupted();
                        System.out.println("check interrupted again: " + b);
                        break; // 线程已经中断，跳出循环
                    } else {
                        System.out.println(threadName + " is not interrupted");
                    }
                    try {
                        int sleepTime = 500;
                        System.out.println(threadName + " start to sleep for " + sleepTime + " ms");
                        Thread.sleep(sleepTime); // 睡眠是一个阻塞方法
                        System.out.println(threadName + " wake up after sleeping");
                    } catch (InterruptedException e) { // 阻塞被打断了抛出中断异常
                        System.out.println(threadName + " is interrupted when sleep");

                        System.out.println("before interrupt(), check interrupted? " + Thread.currentThread().isInterrupted());
                        // 恢复被中断的状态，设置中断标识位，这样下次while循环，会判断标识位，并且退出循环
                        Thread.currentThread().interrupt();
                        System.out.println("after interrupt(), check interrupted? " + Thread.currentThread().isInterrupted());
                    }
                    // yield v. 屈服，当前线程从运行状态变成就绪状态，说明它屈服了，让位出来
                    Thread.yield();
                }
            }
        });

        boolean b = Thread.currentThread().isInterrupted();
        System.out.println(Thread.currentThread().getName() + " is interrupted? " + b);

        t1.start();
        Thread.sleep(200);
        t1.interrupt();

        System.out.println("Interrupt " + t1.getName() + " at " + System.currentTimeMillis());
    }
}
