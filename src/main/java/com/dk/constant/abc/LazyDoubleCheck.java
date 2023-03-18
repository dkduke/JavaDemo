package com.dk.constant.abc;

import java.io.Serializable;

/**
 * @author: dengkun11
 * @date: 2022/09/22
 * @description: 双重检查锁
 */
public class LazyDoubleCheck implements Serializable {

    private static final long serialVersionUID = 7294412297002963777L;

    // 需要添加 volatile 关键字
    private volatile static LazyDoubleCheck instance;

    private LazyDoubleCheck() {
    }

    public static LazyDoubleCheck getInstance() {
        //一重检查：检查实例，如果不存在，进入同步区块
        if (instance == null) {
            synchronized (LazyDoubleCheck.class) {
                //双重检查：进入同步区块后，再检查一次，如果仍然是null，才创建实例
                if (instance == null) {
                    instance = new LazyDoubleCheck();
                }
            }
        }
        return instance;
    }
}
