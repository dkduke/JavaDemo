package com.duke.boot.proxy.javassit;

import cn.hutool.core.collection.ListUtil;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

/**
 * @author: dengkun11
 * @date: 2023/03/14
 * @description: Javassist是一个开源的分析、编辑和创建Java字节码的类库，可以直接编辑和生成Java生成的字节码。
 * 相对于bcel, asm等这些工具，开发者不需要了解虚拟机指令，就能动态改变类的结构，或者动态生成类。
 *
 * 在日常使用中，javassit通常被用来动态修改字节码。它也能用来实现动态代理的功能。
 */
public class CustomJavassitProxy {

    private Object bean;

    public CustomJavassitProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory f = new ProxyFactory();
        f.setSuperclass(bean.getClass());
        f.setFilter(m -> ListUtil.toList("wakeup","sleep").contains(m.getName()));

        Class c = f.createClass();
        MethodHandler mi = (self, method, proceed, args) -> {
            String methodName = method.getName();
            if (methodName.equals("wakeup")){
                System.out.println("早安~~~");
            }else if(methodName.equals("sleep")){
                System.out.println("晚安~~~");
            }
            return method.invoke(bean, args);
        };
        Object proxy = c.newInstance();
        ((Proxy)proxy).setHandler(mi);
        return proxy;
    }
}
