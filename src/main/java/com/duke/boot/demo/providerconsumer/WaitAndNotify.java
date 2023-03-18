package com.duke.boot.demo.providerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengkun11
 * @date: 2022/11/23
 * @description: 线程的等待和通知 - 实现生产/消费模式
 *
 * 假如一个包子铺卖包子，应该是一边生产，一边销售，工作效率最高。如果来了一群顾客，
 * 这时候开始一个个生产效率太低，所以顾客还没来就要开始生产，这就需要一个蒸笼，把生产好的包子放在蒸笼里，顾客来了就卖给顾客。
 *
 * 生产者：生产数据的线程或者进程
 * 消费者：使用数据的线程或进程
 * 而蒸笼就相当于一个缓存区
 * 模式实现思路：
 * 1.添加缓冲区，设置上限
 * 2.向缓存区存放数据，满了使生产者进入等待，有空位置则生产
 * 3.消费者从缓冲区使用数据，缓存区没有数据则消费者等待，有数据再通知消费者
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        BaoZiShop baoZiShop = new BaoZiShop();
        for (int i=0; i<150; i++) {
            new Thread(() -> {
                try {
                    baoZiShop.produceBao(baoZiShop.baoZis.size() + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i=0; i<10; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 20; j++) {
                        baoZiShop.sellBao();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

class BaoZiShop {
    //缓冲区 存放数据
    List<BaoZi> baoZis = new ArrayList<>();

    //上限
    int MAX_COUNT = 100;

    //生产包子
    public synchronized void produceBao(int id) throws InterruptedException {
        if (baoZis.size() == MAX_COUNT) {
            System.out.println("缓存区满了-----------------" + Thread.currentThread().getName() + "等待");
            this.wait();
        } else {
            //通知卖包子
            this.notify();
        }
        BaoZi baoZi = new BaoZi(baoZis.size() + 1);
        baoZis.add(baoZi);
        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName() + "师傅生产一个包子" + baoZi);
    }

    //卖包子
    public synchronized void sellBao() throws InterruptedException {
        if (baoZis.size() == 0) {
            System.out.println("缓存区空-----------" + Thread.currentThread().getName() + "等待");
            this.wait();
        } else {
            //通知生产包子
            this.notify();
        }
        if (baoZis.size() > 0) {
            BaoZi baoZi = baoZis.remove(0);
            Thread.sleep(500);
            System.out.println("顾客买了一个包子" + baoZi);
        }
    }
}

//包子类
class BaoZi{
    public Integer id;

    public BaoZi(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaoZi-"+ id;
    }
}


