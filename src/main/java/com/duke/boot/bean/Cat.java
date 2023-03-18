package com.duke.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: dengkun11
 * @date: 2022/07/16
 * @description: 猫
 */
@ConfigurationProperties(prefix = "cat")
@Component
@ToString
@Data
public class Cat {

    private String name;

    private Integer age;

    private Date birth;

    private Map<String, Object> score;

    private Pet pet;

    private List<String> interests;
}
