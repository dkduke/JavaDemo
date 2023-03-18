package com.duke.boot.patten.oberver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author: dengkun11
 * @date: 2022/11/07
 * @description: 创建 DemoApplication 类，应用启动类
 */
@SpringBootApplication
@EnableAsync // 开启 Spring 异步的功能
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
