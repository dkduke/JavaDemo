package com.duke.boot.strategy;

/**
 * @author: dengkun11
 * @date: 2023/01/16
 * @description: 单例美食策略
 */
public class Food extends AbstractStrategy implements Strategy {

    private static final Food instance = new Food();

    private FoodService foodService;

    private Food() {
        register();
    }

    public static Food getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {
        //

    }
}
