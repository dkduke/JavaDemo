package com.duke.boot.config;

import com.duke.boot.bean.User;
import com.duke.boot.util.DbHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、proxyBeanMethods 代理bean的方法
 *  Full（proxyBeanMethods = true） - 同一个bean
 *  Lite（proxyBeanMethods = false） - 不同bean
 *
 *  2、@Import 给容器中自动创建这两个类型的组件,默认组件名字就是全类名
 */
@Import({User.class, DbHelper.class})
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    //容器中添加组件，以方法名作为组件id，返回类型就是组件类型
    @Bean
    public User user01() {
        return new User("zhangsan", 18);
    }
}
