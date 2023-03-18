package com.duke.boot.async;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: dengkun11
 * @date: 2022/11/14
 * @description: ThreadPoolExecutor
 */
public class UseThreadPoolExecutor {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, //coreSize
                2, //MaximumPoolSize；最大的线程数量
                60, //keepAliveTime 线程活动保持时间，线程池的工作线程空闲后，保持存活的时间。
                TimeUnit.SECONDS,
                //new ArrayBlockingQueue<Runnable>(3), //有界队列,
                new LinkedBlockingQueue<Runnable>(4),  // 无界
                new CusRejected()
        );

        CusTask cusTask1 = new CusTask(1, "task 1");
        CusTask cusTask2 = new CusTask(2, "task 2");
        CusTask cusTask3 = new CusTask(3, "task 3");
        CusTask cusTask4 = new CusTask(4, "task 4");
        CusTask cusTask5 = new CusTask(5, "task 5");
        CusTask cusTask6 = new CusTask(6, "task 6");
        CusTask cusTask7 = new CusTask(7, "task 7");

        pool.execute(cusTask1);
        pool.execute(cusTask2);
        pool.execute(cusTask3);
        pool.execute(cusTask4);
        pool.execute(cusTask5);
        pool.execute(cusTask6);
        pool.execute(cusTask7);

        pool.shutdown();
    }
}
