package com.duke.boot.demo;

import org.checkerframework.checker.nullness.Opt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: dengkun11
 * @date: 2022/08/29
 * @description: Stream
 */
public class StreamDemo {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("张无忌");
//        list.add("周芷若");
//        list.add("赵敏");
//        list.add("小昭");
//        list.add("殷离");
//        list.add("张三");
//        list.add("张三丰");
//        list.stream()
//                .filter(name -> name.startsWith("张"))
//                .filter(name -> name.length() == 3)
//                .forEach(name -> System.out.println(name));

       List<Integer> list = Arrays.asList(7,6,5,8,9,12,0,2,3);

       list.stream().filter(x -> x > 6).forEach(System.out::println);

        List<Integer> newList = list.stream().filter(x -> x > 6).filter(x -> x < 9).collect(Collectors.toList());

        System.out.println(newList.toString());

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    }

}
