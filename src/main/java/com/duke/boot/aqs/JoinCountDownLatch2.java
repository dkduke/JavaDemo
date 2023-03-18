package com.duke.boot.aqs;

import java.util.concurrent.*;

/**
 * @author: dengkun11
 * @date: 2022/07/27
 * @description: 使用ExecutorService 2.4 12 24+4.8 28.8 9  37
 * 39
 * */
public class JoinCountDownLatch2 {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    private static ExecutorService executorService = new ThreadPoolExecutor(2, 3, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20), new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("child threadOne over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        executorService.submit(new Runnable() {
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

        System.out.println("wait all child thread over!");

        //等待子线程执行完毕， 返回
        countDownLatch.await();

        System.out.println("all child thread over!");

        executorService.shutdown();

    }
}
