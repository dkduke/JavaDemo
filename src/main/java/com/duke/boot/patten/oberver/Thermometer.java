package com.duke.boot.patten.oberver;

import java.util.Observable;

/**
 * @author: dengkun11
 * @date: 2023/03/03
 * @description: 温度计 被观察者
 */
public class Thermometer extends Observable {

    // 温度
    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * 监控温度
     */
    public void monitor(){
        if (temperature > 25) {
            System.out.println("温度高于25°C，通知观察者...");
            // 温度变化
            super.setChanged();
            // 通知观察者
            super.notifyObservers(temperature);
        }
    }

}
