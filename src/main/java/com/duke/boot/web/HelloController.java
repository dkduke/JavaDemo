package com.duke.boot.web;

import com.duke.boot.bean.Car;
import com.duke.boot.bean.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Car car;

    @Autowired
    private Cat cat;

    @RequestMapping("/car")
    public Car myCar() {
        return car;
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/cat")
    public Cat cat() {
        return cat;
    }
}
