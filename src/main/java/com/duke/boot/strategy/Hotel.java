package com.duke.boot.strategy;

/**
 * @author: dengkun11
 * @date: 2023/01/16
 * @description: 单例酒旅策略
 */
public class Hotel extends AbstractStrategy implements Strategy {

    private static final Hotel instance = new Hotel();

    private HotelService hotelService;

    private Hotel() {
        register();
    }

    public static Hotel getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {
        //
    }
}
