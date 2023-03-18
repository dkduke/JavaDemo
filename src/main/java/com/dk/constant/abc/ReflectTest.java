package com.dk.constant.abc;

import java.lang.reflect.Constructor;

/**
 * @author: dengkun11
 * @date: 2022/09/22
 * @description: 反射Test
 */
public class ReflectTest {

    public static void main(String[] args) {
        lazyDoubleCheckTest();
        enumSingletonTest();
    }

    /**
     * 反射破坏了单例
     */
    private static void lazyDoubleCheckTest() {
        try {
            Class<?> clazz = LazyDoubleCheck.class;

            //通过反射弧获取类的私有构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问
            c.setAccessible(true);

            Object obj1 = c.newInstance();
            Object obj2 = c.newInstance();

            //输出false
            System.out.println(obj1 == obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 枚举实现单例反射测试
     */
    private static void enumSingletonTest() {
        try {
            Class<?> clazz = EnumSingleton.class;

            //通过反射获取类的私有构造方法
            //Constructor c = clazz.getDeclaredConstructor(null);  //无无参构造方法
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            //强制访问
            c.setAccessible(true);

            //语法上，不允许通过反射实例化枚举类对象
            Object obj1 = c.newInstance();
            Object obj2 = c.newInstance();

            System.out.println(obj1 == obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
