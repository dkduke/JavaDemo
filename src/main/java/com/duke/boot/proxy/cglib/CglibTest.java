package com.duke.boot.proxy.cglib;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description:
 */
public class CglibTest {

    public static void main(String[] args) {
        CustomCglibProxy proxy = new CustomCglibProxy(new Student("duke"));
        Student student = (Student) proxy.getProxy();
        student.wakeup();
        student.sleep();
    }
}
