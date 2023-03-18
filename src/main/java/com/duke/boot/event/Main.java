package com.duke.boot.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: dengkun11
 * @date: 2022/08/06
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);

        demoPublisher.publish("hello, application event");
        context.close();
    }
}
