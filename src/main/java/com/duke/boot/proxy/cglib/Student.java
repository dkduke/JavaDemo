package com.duke.boot.proxy.cglib;

import cn.hutool.core.util.StrUtil;
import com.duke.boot.proxy.jdk.Person;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description:
 */
public class Student implements Person {

    private String name;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void rentHouse() {
    }

    @Override
    public void wakeup() {
        System.out.println(StrUtil.format("学生[{}]早晨醒来啦",name));
    }

    @Override
    public void sleep() {
        System.out.println(StrUtil.format("学生[{}]晚上睡觉啦",name));
    }
}
