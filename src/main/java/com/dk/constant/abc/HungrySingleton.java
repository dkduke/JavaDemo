package com.dk.constant.abc;

/**
 * @author: dengkun11
 * @date: 2022/09/22
 * @description: 饿汉式单例
 *
 * 单例模式就是确保一个类在任何情况下都只有一个实例，并提供一个全局访问点。
 *
 * 对象未被使用的情况下就会被初始化，且线程安全
 */
public class HungrySingleton {

    //类初始化的时候便进行对象实例化
    private static final HungrySingleton hungrySingleton = new HungrySingleton();


    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
