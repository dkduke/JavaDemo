package com.duke.boot.patten.facade;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: test
 */
public class FacadeTest {

    public static void main(String[] args) {
        DealOrderFacade facade = new DealOrderFacade();

        facade.createOrder();

        System.out.println("*********************");

        facade.payOrder();
    }
}
