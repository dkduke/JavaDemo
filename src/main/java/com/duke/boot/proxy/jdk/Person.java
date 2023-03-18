package com.duke.boot.proxy.jdk;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description: 创建一个person接口，这个接口就是租客和中介的公共接口，这个接口有一个rentHouse（）方法。
 */
public interface Person {

    /**
     * 租房
     */
    public void rentHouse();

    public void wakeup();

    public void sleep();
}
