package com.duke.boot.sirector.proxy;

import com.jd.m.sirector.wrapper.event.EventProxy;

/**
 * @author: dengkun11
 * @date: 2023/01/05
 * @description: 定义一个事件处理类MyProxy, 实现EventProxy接口
 */
public class MyEventProxy implements EventProxy {

    public Object method1(Object param) throws InterruptedException {
        //Thread.sleep(1000);
        System.out.println("method1 execute");
        return param;
    }

    public Object method2(Object param) {
        System.out.println("method2 execute");
        return param;
    }

    public Object method3(Object param, Object[] preResult) {
        System.out.println("method3 execute");
        return preResult[0] + ", " + preResult[1];
    }

    public Object method4(Object param, Object object1) {
        System.out.println("method4 execute");
        return object1;
    }

    public Object method5(Object param, Object object1) {
        System.out.println("method5 execute");
        return object1;
    }

    public Object method6(Object param, Object[] preResult) {
        System.out.println("method6 execute");
        return preResult[0] + ", " + preResult[1];
    }
}
