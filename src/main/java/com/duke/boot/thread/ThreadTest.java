package com.duke.boot.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: dengkun11
 * @date: 2023/03/02
 * @description:
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                0,
                Integer.MAX_VALUE,
                1,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new CustomerThreadFactory("customerThread"));

        for (int i = 0; i<10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
