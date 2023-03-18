package com.duke.boot;

import com.duke.boot.bean.Cat;
import com.duke.boot.bean.User;
import com.duke.boot.config.MyConfig;
import com.duke.boot.domain.FooProperties;
import com.duke.boot.util.DbHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootConfiguration // 说明是springboot的核心配置类
@ComponentScan("com.duke.boot") //指定扫描哪些类
@EnableAutoConfiguration //含@AutoConfigurationPackage和@Import({AutoConfigurationImportSelector.class})
//@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);

        Binder binder = Binder.get(context.getEnvironment());

        // 绑定简单配置
        FooProperties foo = binder.bind("com.duke", Bindable.of(FooProperties.class)).get();
        System.out.println(foo.getFoo());

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //从容器中获取组件 @Bean注册的组件默认是单例的
        User user1 = context.getBean("user01", User.class);
        User user2 = context.getBean("user01", User.class);
        System.out.println(user1 == user2);

        MyConfig myConfig = context.getBean(MyConfig.class);
        System.out.println(myConfig);

        User user3 = myConfig.user01();
        System.out.println(user1 == user3);

        String[] beanNames = context.getBeanNamesForType(User.class);
        System.out.println("=======");
        for (String name : beanNames) {
            System.out.println(name);
        }

        DbHelper dbHelper = context.getBean(DbHelper.class);
        System.out.println(dbHelper);

    }
}
