package com.duke.boot.patten.facade;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 商品子系统
 */
public class Good {
    public void lockStore() {
        System.out.println("锁定库存");
    }

    public void updateStore() {
        System.out.println("更新库存");
    }
}