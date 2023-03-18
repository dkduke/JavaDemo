package com.duke.boot.demo;

/**
 * @author: dengkun11
 * @date: 2022/08/30
 * @description:
 */
public class Demo {

    public static void main(String[] args) {
        //每种商品数量
        int[] nums = {1,1,1,1};
        //总预算
        double total = 132;
        //增长系数
        double x = 1.2;

        double res = getBasePrice(nums, total, x);
        System.out.printf("%.2f%n", res);
    }

    public static double getBasePrice(int[] nums, double total, double x) {
        //前一个商品的系数
        double preRatios = 1;
        double prices = 0;
        for (int num : nums) {
            preRatios = preRatios * x;
            prices += preRatios * num;
        }
        return total/prices;
    }

}
