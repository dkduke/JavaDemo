package com.dk.constant;


/**
 * @author: dengkun11
 * @date: 2022/09/13
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        
        int a = 1;
        
        int c = ++a + a;

        System.out.println(c);

//        for (int i = 1; i < 3; i++) {
//            Integer code = i;
//
//            // 策略体现在根据不同的 code 获取不同的 insurance
//            InsuranceEnum insurance = InsuranceEnum.getByCode(code);
//            insurance.settle("i: " + i);
//
//            // 而不是 switch 的手工对应
//            // 枚举里的 Map 就是表驱动
////            switch (code) {
////                case 1: {
////                    InsuranceEnum.INSURANCE_1.settle("i: " + i);
////                    break;
////                }
////                case 2: {
////                    InsuranceEnum.INSURANCE_2.settle("i: " + i);
////                    break;
////                }
////            }
//        }
//
//        System.out.println(User.getInstance());
//
//        System.out.println(User.getInstance());
//
//        System.out.println(User.getInstance() == User.getInstance());
//
//        System.out.println(SingletonEnum.getInstance() == SingletonEnum.getInstance());
//        System.out.println(SingletonEnum.getInstance());

    }
}
