package com.duke.boot.atomic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: dengkun11
 * @date: 2023/03/15
 * @description: 一个加锁解锁的 CASLock
 *
 * 在 tryLock 方法中，我们先使用 CAS 方法进行更新，如果更新不成功则抛出异常，并把当前线程设置为加锁线程。
 * 在 unLock 方法中，我们先判断当前值是否为 0 ，如果是 0 就是我们愿意看到的结果，直接返回。
 * 否则是 1，则表示当前线程还在加锁，我们再来判断一下当前线程是否是加锁线程，如果是则执行解锁操作。
 */
public class CASLock {

    AtomicInteger atomicInteger = new AtomicInteger();
    Thread currentThread = null;

    public void tryLock() throws Exception {
        boolean isLock = atomicInteger.compareAndSet(0,1);
        if (!isLock) {
            throw new Exception("加锁失败");
        }

        currentThread = Thread.currentThread();
        System.out.println(currentThread + "tryLock");
    }

    public void unlock() {
        int lockValue = atomicInteger.get();
        // 0: 说明是解锁状态
        if(lockValue == 0) {
            return;
        }
        if (currentThread == Thread.currentThread()) {
            atomicInteger.compareAndSet(1, 0);
            System.out.println(currentThread + " unlock");
        }
    }

    public static void main(String[] args) {
        CASLock casLock = new CASLock();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 5,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.AbortPolicy()
        );

//        for (int i=0; i<5; i++) {
//            new Thread( () -> {
//                try {
//                    casLock.tryLock();
//                    Thread.sleep(10000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    casLock.unlock();
//                }
//            }).start();
//        }

        for (int i=0; i<5; i++) {
            threadPoolExecutor.execute(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           casLock.tryLock();
                           Thread.sleep(5000);
                       } catch (Exception e) {
                           e.printStackTrace();
                       } finally {
                           casLock.unlock();
                       }
                   }
               }
            );
        }

        threadPoolExecutor.shutdown();
    }
}
