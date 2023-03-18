package com.duke.boot.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description: cglib代理
 * 动态代理需要被代理类实现接口，如果被代理类没有实现接口，那么这么实现动态代理？
 * 这时候就需要用到CGLib了。这种代理方式就叫做CGlib代理。
 *
 * Cglib代理也叫作子类代理，他是通过在内存中构建一个子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，然后加入自己需要的操作。
 * 因为使用的是继承的方式，所以不能代理final 类。
 */
public class CustomCglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    private Object bean;

    public CustomCglibProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy(){
        //设置需要创建子类的类
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("wakeup")) {
            System.out.println("good moning");
        } else if (methodName.equals("sleep")) {
            System.out.println("good night");
        }
        return method.invoke(bean, objects);
    }
}
