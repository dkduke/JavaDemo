package com.duke.boot;

import com.duke.boot.bean.User;
import com.duke.boot.factory.FactoryBeanTest;
import com.jd.m.sirector.wrapper.event.EventExecute;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: dengkun11
 * @date: 2023/01/05
 * @description:
 */
public class SpringMainApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        EventExecute execute1 = (EventExecute) ctx.getBean("execute1");
        System.out.println(execute1.toString());
        System.out.println(execute1.execute("this is a test"));

//        //获取BeanDefiniton
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        //简单的创建一个Bean
//        beanDefinition.setBeanClass(FactoryBeanTest.class);
//
//        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();
//        //将BeanDefinition创建到容器对象里面去
//        applicationContext1.registerBeanDefinition("user", beanDefinition);
//        applicationContext1.refresh();
//
//        //注意：此时我们注册进Spring中的Bean有些特殊，他实现了两个实际上创建了两个Bean对象，
//        // 第一个就是我们的FactoryBean_teat, 还有一个就是我们的User对象
//        //此时id:&user表示的是FactoryBean_teat，id:user表示的是User对象。
//
//        //获取生产出来的对象
//        //User user1 = applicationContext1.getBean("user", User.class);
//        User user1 = (User) applicationContext1.getBean("user");
//        //获取工厂对象
//        FactoryBeanTest factoryBeanTest = applicationContext1.getBean("&user", FactoryBeanTest.class);
//
//        System.out.println(user1.toString());
//
//        System.out.println(factoryBeanTest.toString());
    }
}
