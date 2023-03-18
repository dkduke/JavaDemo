package com.duke.boot.patten.facade;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 处理订单相关facade
 *
 * 提供一个统一的接口，用来访问子系统中的一群接口，外观定义了一个高层接口,让子系统更容易使用
 */
public class DealOrderFacade {

    private Account account = new Account();
    private Order order = new Order();
    private Good good = new Good();

    public void createOrder() {
        account.createAccount();

        order.preOrder();

        good.lockStore();
    }

    public void payOrder() {
        account.updateAccount();

        order.issueOrder();

        good.updateStore();
    }
}
