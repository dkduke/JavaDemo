package com.dk.constant;

/**
 * @author: dengkun11
 * @date: 2022/09/14
 * @description: 枚举单例
 */
public enum SingletonEnum {

    //单例
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}


