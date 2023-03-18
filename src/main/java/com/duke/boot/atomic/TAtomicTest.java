package com.duke.boot.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: dengkun11
 * @date: 2023/03/15
 * @description:
 */
public class TAtomicTest implements Runnable {

    AtomicInteger atomicInteger = new AtomicInteger(200);

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            //System.out.println(atomicInteger.getAndIncrement());
            //System.out.println(atomicInteger.getAndDecrement());
            System.out.println(atomicInteger.decrementAndGet());
        }
    }

    public static void main(String[] args) {
        TAtomicTest tAtomicTest = new TAtomicTest();

        Thread t1 = new Thread(tAtomicTest);
        Thread t2 = new Thread(tAtomicTest);

        t1.start();
        t2.start();
    }
}
