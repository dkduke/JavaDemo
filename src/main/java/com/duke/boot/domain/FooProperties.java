package com.duke.boot.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.duke")
public class FooProperties {

    private String foo;
}
