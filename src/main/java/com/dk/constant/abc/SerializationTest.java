package com.dk.constant.abc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: dengkun11
 * @date: 2022/09/22
 * @description: 序列化测试
 */
public class SerializationTest {

    public static void main(String[] args) {
        lazyDoubleCheckTest();
        enumSingletonTest();
    }

    /**
    * 序列化破坏双重检查实现的单例
     */
    private static void lazyDoubleCheckTest() {
        LazyDoubleCheck s1 = LazyDoubleCheck.getInstance();
        LazyDoubleCheck s2 = null;

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (LazyDoubleCheck) ois.readObject();
            ois.close();
            fis.close();

            //输出为false 不同对象
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化枚举单例
     */
    private static void enumSingletonTest() {
        EnumSingleton s1 = EnumSingleton.getInstance();
        s1.setData(new Object());
        EnumSingleton s2 = null;

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //判断是Enum类型，则会通过Enum.valueOf从enumConstantDirectory Map中获取
            // Enum中定义的Enum成员值都被缓存在了这个Map中，Key是成员名称（比如“INSTANCE”），Value就是Enum的成员对象。
            // 这种机制天然保证了取到的Enum对象是唯一的。即使是反序列化，也是一样的。
            s2 = (EnumSingleton) ois.readObject();
            ois.close();
            fis.close();

            //输出为true  相同对象
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
