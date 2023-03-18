package com.duke.boot.patten.oberver;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: dengkun11
 * @date: 2023/03/03
 * @description: 观察者
 */
public class Man implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("主人收到消息，温度是" + arg + "°C");
        System.out.println("关闭窗户...");
    }
}
