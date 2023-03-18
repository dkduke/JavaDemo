package com.duke.boot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: dengkun11
 * @date: 2022/08/06
 * @description: 事件监听器
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    //使用onApplicationEvent方法对消息进行接受处理
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();

        System.out.println("[bean-demoListener] 监听到了bean-demoPublisher发布的消息：" + msg);
    }
}
