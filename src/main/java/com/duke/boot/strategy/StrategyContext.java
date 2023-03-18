package com.duke.boot.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengkun11
 * @date: 2023/01/16
 * @description: 策略上下文
 */
public class StrategyContext {

    private static final Map<String, Strategy> registerMap = new HashMap<>();

    //注册策略
    public static void registerStrategy(String rewardType, Strategy strategy) {
        registerMap.putIfAbsent(rewardType, strategy);
    }

    //获取策略
    public static Strategy getStrategy(String rewardType) {
        return registerMap.get(rewardType);
    }
}
