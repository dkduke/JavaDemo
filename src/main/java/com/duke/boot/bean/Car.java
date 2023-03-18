package com.duke.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: dengkun11
 * @date: 2022/07/16
 * @description: car
 *
 * 只有在容器中的组件才拥有springboot提供的强大功能
 * @ConfigurationProperties - 指定配置
 */
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;

    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
