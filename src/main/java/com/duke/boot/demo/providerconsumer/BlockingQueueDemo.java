package com.duke.boot.demo.providerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: dengkun11
 * @date: 2022/11/23
 * @description: 阻塞队列实现生产者-消费者模式
 */
public class BlockingQueueDemo {

    static class Baozi {
        private int id;
        public Baozi(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "BaoZi--" + id;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Baozi> baozis = new ArrayBlockingQueue<>(100);
        new Thread(() -> {
            for (int i=0; i<200; i++) {
                Baozi baozi = new Baozi(baozis.size() + 1);
                try {
                    baozis.put(baozi);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "生产了" + baozi);
            }
        }).start();

        for (int i=0; i<5; i++) {
            new Thread(() -> {
                for (int j=0; j < 40; j++) {
                    try {
                        Baozi take = baozis.take();
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "消费了" + take);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
