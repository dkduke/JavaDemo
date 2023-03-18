package com.duke.boot.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author: dengkun11
 * @date: 2022/07/27
 * @description: countDownLatch
 *
 * AQS，它是基于CLH队列锁设计的同步组件框架。JAVA中常用的显示锁、CountDownLatch、Semaphore、读写锁等，都基于它来实现。
 *
 *
 */
public class JoinCountDownLatch {

    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("child threadOne over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("child threadTwo over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });

        //启动子线程
        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        //等待子线程执行完毕， 返回
        countDownLatch.await();

        System.out.println("all child thread over!");
    }

}
