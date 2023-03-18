package com.duke.boot.patten.oberver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 创建 EmailService 类，邮箱 Service
 */
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> { // <1> 实现 ApplicationListener 接口，通过 E 泛型设置感兴趣的事件。

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Async // <3>  设置 @Async 注解，声明异步执行。毕竟实际场景下，发送邮件可能比较慢，又是非关键逻辑。
    public void onApplicationEvent(UserRegisterEvent event) { // <2> 实现 #onApplicationEvent(E event) 方法，针对监听的 UserRegisterEvent 事件，进行自定义处理。
        logger.info("[onApplicationEvent][给用户({}) 发送邮件]", event.getUsername());
    }

}
