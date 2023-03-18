package com.duke.boot.patten.oberver;

import java.util.Observer;

/**
 * @author: dengkun11
 * @date: 2023/03/03
 * @description:
 * 观察者模式的实际应用有很多，比如Tomcat中的生命周期，就是典型的观察者模式，了解了观察者模式之后，再要了解Tomcat的生命周期就会非常容易了。
 *
 * 再比如现实生活中的例子，点一份外卖，点的商品相当于被观察者，商家和送餐员相当于观察者，
 * 点餐时，通知商家下订单，并且也会通知送餐员去商家取餐，而点餐的你也相当于观察者，可以查看送餐的进度。
 * 所以，观察者模式的用途也是比较广泛的。
 */
public class Client {

    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer();
        Observer man = new Man();
        Observer airConditioner = new AirConditioner();

        // 添加观察者
        thermometer.addObserver(man);
        thermometer.addObserver(airConditioner);

        // 设置温度为26°C
        thermometer.setTemperature(26);

        // 开始监控
        thermometer.monitor();
    }
}
