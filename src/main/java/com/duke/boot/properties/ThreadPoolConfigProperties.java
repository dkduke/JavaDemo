package com.duke.boot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: dengkun11
 * @date: 2022/11/23
 * @description: 线程池配置文件
 */
@ConfigurationProperties(prefix = "bookstore.thread")
@Component
@Data
public class ThreadPoolConfigProperties {
    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;
}
