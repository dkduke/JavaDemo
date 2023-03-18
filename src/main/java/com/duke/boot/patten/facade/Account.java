package com.duke.boot.patten.facade;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 账户子系统
 *  背景：对外提供订单下单和出单两个接口
 */
public class Account {
    public void createAccount() {
        System.out.println("创建账户");
    }

    public void updateAccount() {
        System.out.println("更新账户余额");
    }
}
