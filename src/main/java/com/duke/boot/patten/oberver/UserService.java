package com.duke.boot.patten.oberver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 创建 UserService 类，用户 Service
 */
@Service
public class UserService implements ApplicationEventPublisherAware { // <1> 实现 ApplicationEventPublisherAware 接口，从而将 ApplicationEventPublisher 注入到其中。

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username) {
        // ... 执行注册逻辑
        logger.info("[register][执行用户({}) 的注册逻辑]", username);

        // <2>  在执行完注册逻辑后，调用 ApplicationEventPublisher 的 #publishEvent(ApplicationEvent event) 方法，
        // 发布「3.2 UserRegisterEvent」事件。
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, username));
    }

}
