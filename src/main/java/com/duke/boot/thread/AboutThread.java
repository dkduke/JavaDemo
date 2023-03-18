package com.duke.boot.thread;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.*;

/**
 * @author: dengkun11
 * @date: 2023/03/02
 * @description: 线程饥饿死锁
 *
 * 线程饥饿死锁。在线程池中，如果一个任务将另一个任务提交到同一个Executor，那么通常会引发死锁。
 * 第二个线程停留在工作队列中等待第一个提交的任务执行完成，但是第一个任务又无法执行完成，因为它在等待第二个任务执行完成。
 */
public class AboutThread {

    //ExecutorService executorService = Executors.newSingleThreadExecutor();
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        AboutThread aboutThread = new AboutThread();
        aboutThread.threadDeadLock();

    }

    public void threadDeadLock(){
        Future<String> taskOne  = executorService.submit(new TaskOne());
        try {
            System.out.println("等待taskOne完成..." + Thread.currentThread().getName());
            System.out.println("taskOne.get(): " + taskOne.get());
            System.out.println("taskOne执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public class TaskOne implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println("TaskOne执行中，提交TaskTwo任务，" + Thread.currentThread().getName());
            Future<String> taskTow = executorService.submit(new TaskTwo());
            System.out.println("等待TaskTwo完成...");
            return "TaskOne + " + taskTow.get();
        }
    }

    public class TaskTwo implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("taskTwo执行");
            return "TaskTwo";
        }
    }
}
