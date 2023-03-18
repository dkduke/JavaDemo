package com.duke.boot.proxy.jdk;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description: 被代理的类
 */
public class Renter implements Person {

    String name;

    @Override
    public void rentHouse() {
        System.out.println("租客租房成功！");
    }

    @Override
    public void wakeup() {

    }

    @Override
    public void sleep() {

    }

}
