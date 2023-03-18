package com.duke.boot.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description: RenterInvocationHandler类，
 * 这个类实现了InvocationHandler接口，
 * 并持有一个被代理类的对象，InvocationHandler中有一个invoke方法，
 * 所有执行代理对象的方法都会被替换成执行invoke方法。
 * 然后通过反射在invoke方法中执行代理类的方法。
 * 在代理过程中，在执行代理类的方法前或者后可以执行自己的操作，这就是spring aop的主要原理。
 */
public class RenterInvocationHandler<T> implements InvocationHandler {

    /**
     * 被代理类的对象
     */
    private T target;

    public RenterInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("租客和中介交流");
        Object result = method.invoke(target, args);
        return result;
    }
}
