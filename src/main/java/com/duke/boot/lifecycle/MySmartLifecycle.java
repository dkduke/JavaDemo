package com.duke.boot.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * @author: dengkun11
 * @date: 2022/08/18
 * @description: 定义一个类实现SmartLifecycle接口
 */
public class MySmartLifecycle implements SmartLifecycle {

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
