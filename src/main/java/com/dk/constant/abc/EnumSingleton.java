package com.dk.constant.abc;

/**
 * @author: dengkun11
 * @date: 2022/09/20
 * @description: 单例枚举
 */
public enum EnumSingleton {

    //单例
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
