package com.duke.boot.strategy;

/**
 * @author: dengkun11
 * @date: 2023/01/16
 * @description: 单例外卖策略
 */
class Waimai extends AbstractStrategy implements Strategy{

    private static final Waimai instance = new Waimai();

    private WaimaiService waimaiService;

    private Waimai() {
        register();
    }

    public static Waimai getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {
        //
    }
}
