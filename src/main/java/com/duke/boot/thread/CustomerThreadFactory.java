package com.duke.boot.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: dengkun11
 * @date: 2023/03/02
 * @description: 定制线程池
 */
public class CustomerThreadFactory implements ThreadFactory {

    private String name;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    CustomerThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name+threadNumber.getAndIncrement());
        return thread;
    }
}
