package com.duke.boot.proxy.javassit;

import com.duke.boot.proxy.cglib.Student;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description:
 */
public class JavassitTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        CustomJavassitProxy proxy = new CustomJavassitProxy(new Student("123"));
        Student student = (Student) proxy.getProxy();
        student.wakeup();
        student.sleep();
    }
}
