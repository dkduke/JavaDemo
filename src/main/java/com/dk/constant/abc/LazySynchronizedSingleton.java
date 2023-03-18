package com.dk.constant.abc;

/**
 * @author: dengkun11
 * @date: 2022/09/22
 * @description: 懒汉式单例-同步锁
 */
public class LazySynchronizedSingleton {

    private static LazySynchronizedSingleton instance;

    private LazySynchronizedSingleton() {
    }

    //添加synchronized关键字
    public synchronized static LazySynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new LazySynchronizedSingleton();
        }
        return instance;
    }
}
