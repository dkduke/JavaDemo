package com.dk.constant.abc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author: dengkun11
 * @date: 2022/09/20
 * @description: 测试
 */
public class Test {

    public static void main(String[] args) {

//        EnumSingleObject s1 = EnumSingleObject.getInstance();
//        EnumSingleObject s2 = null;
//
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("SeriableSingleton.obj");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(s1);
//            oos.flush();
//            oos.close();
//            fos.close();
//
//            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            s2 = (EnumSingleObject) ois.readObject();
//            ois.close();
//            fis.close();
//
//            //输出为false
//            System.out.println(s1 == s2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




//        EnumSingleObject2 s1 = EnumSingleObject2.getInstance();
//        //EnumSingleObject s1 = EnumSingleObject.getInstance();
//        s1.setData(new Object());
//        EnumSingleObject2 s2 = null;
//
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream("SeriableSingleton.obj");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(s1);
//            oos.flush();
//            oos.close();
//            fos.close();
//
//            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            s2 = (EnumSingleObject2) ois.readObject();
//            ois.close();
//            fis.close();
//
//            //输出为true
//            System.out.println(s1 == s2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        try {
            Class<?> clazz = EnumSingleton.class;

            //通过反射获取类的私有构造方法
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            //强制访问
            c.setAccessible(true);

            Object obj1 = c.newInstance();
            Object obj2 = c.newInstance();

            System.out.println(obj1 == obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        String np = "1234567";
//        EnumSingleton.getInstance().setData(np);
//        System.out.println(EnumSingleton.getInstance().getData());
    }
}
