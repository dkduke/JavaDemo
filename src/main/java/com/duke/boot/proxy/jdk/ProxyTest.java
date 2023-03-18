package com.duke.boot.proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description: 创建动态代理对象
 */
public class ProxyTest {

    public static void main(String[] args) {

        //创建被代理的实例对象
        Person renter = new Renter();

        //创建InvocationHandler对象
        InvocationHandler renterHandler = new RenterInvocationHandler<Person>(renter);

        //创建代理对象,代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person renterProxy = (Person) Proxy.newProxyInstance(
                Person.class.getClassLoader(),
                new Class<?>[]{Person.class},
                renterHandler);
        renterProxy.rentHouse();



        //--------也可以使用下面的方式创建代理类对象，Proxy.newProxyInstance其实就是对下面代码的封装-------
		try {
			//使用Proxy类的getProxyClass静态方法生成一个动态代理类renterProxy
			Class<?> renterProxyClass = Proxy.getProxyClass(
                    Person.class.getClassLoader(),
                    new Class<?>[]{Person.class});
			//获取代理类renterProxy的构造器，参数为InvocationHandler
			Constructor<?> constructor = renterProxyClass.getConstructor(InvocationHandler.class);
			//使用构造器创建一个代理类实例对象
			Person renterProxy2 = (Person)constructor.newInstance(renterHandler);
			renterProxy2.rentHouse();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
