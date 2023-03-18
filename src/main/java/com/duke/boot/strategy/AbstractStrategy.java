package com.duke.boot.strategy;

/**
 * @author: dengkun11
 * @date: 2023/01/16
 * @description: 抽象策略类
 */
abstract class AbstractStrategy implements Strategy {

    //类注册方法
    public void register() {
        StrategyContext.registerStrategy(getClass().getSimpleName(), this);
    }
}
