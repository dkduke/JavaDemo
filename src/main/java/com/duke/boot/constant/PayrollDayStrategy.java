package com.duke.boot.constant;

/**
 * @author: dengkun11
 * @date: 2022/08/12
 * @description: 枚举策略
 */
public enum PayrollDayStrategy {

    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDayStrategy(PayType payType){
        this.payType = payType;
    }

    double pay(double hoursWorked, double payRate){
        return payType.pay(hoursWorked, payRate);
    }

    private enum PayType {

        WEEKDAY {
            @Override
            double overtimePay(double hours, double payRate){
                return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;
            }
        },

        WEEKEND{
            @Override
            double overtimePay(double hours, double payRate){
                return hours * payRate / 2;
            }
        };

        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        double pay(double hoursWorked, double payRate){
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
