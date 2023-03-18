package com.dk.constant;

/**
 * @author: dengkun11
 * @date: 2022/09/15
 * @description:
 */
public enum ResultCode {

    //
    SUCCESS("成功",200),
    SYSTEM_ERROR("系统错误",500),
    NET_TIMEOUT("网络超时",400);

    private String name;
    private int code;

    ResultCode(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}

