package com.duke.boot.constant;

/**
 * @author: dengkun11
 * @date: 2022/08/12
 * @description: 考虑用一个 enum 表示薪资包中的每个工作日的薪资.
 * 这个枚举有一些方法，根据给定某工人的基本工资 (按小时) 以及当天的工作时间，来计算他当天的报酬.
 * 在五个工作日中，超过正常 8 小时的工作时间都会产生加班工资，在双休日中，所有工作都产生加班工资.
 * 利用 switch 语句，很容易通过将多个 case 标签分别应用到俩个代码片段中，来完成这一计算
 */
public enum PayrollDay {

    /**
     * 星期一
     */
    MONDAY,
    TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY;

    private static final int HOURS_PER_SHIFT = 8;

    double pay(double hoursWorked, double payRate){
        double basePay = hoursWorked * payRate;
        double overtimePay;
        switch(this){
            case SATURDAY: case SUNDAY:
                overtimePay = hoursWorked * payRate  / 2; break;
            default:
                overtimePay = hoursWorked <= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
                break;
        }
        return basePay + overtimePay;
    }

}
