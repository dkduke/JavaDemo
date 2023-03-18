package com.duke.boot.constant;

/**
 * @author: dengkun11
 * @date: 2022/09/11
 * @description:
 */
public class EnumTest {

    public static void main(String[] args) {
        PayrollDayStrategy monday = PayrollDayStrategy.MONDAY;
        monday.pay(9, 100);
    }
}
