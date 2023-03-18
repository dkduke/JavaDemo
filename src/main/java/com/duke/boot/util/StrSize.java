package com.duke.boot.util;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: dengkun11
 * @date: 2022/11/30
 * @description: 字符串大小
 */
public class StrSize {

    public static void main(String[] args) {
        String str = "32";
        HashSet set = new HashSet();
        for(int i=0; i<2200; i++) {
            set.add(str + i);
        }

        System.out.println(set.toString());
        System.out.println(set.contains("321728"));
        System.out.println(TimeUnit.DAYS.toMinutes(2));

        System.out.println("utf-8编码下\"12345678\"所占的字节数量：" + set.toString().getBytes(StandardCharsets.UTF_8).length);

        //list循环遍历remove的坑
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("原始list：" + list);

        //正序遍历移除元素 不符合预期，跳跃了，没删干净
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println("for循环正序遍历移除元素结果：" + list);

        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        //倒序遍历移除元素 符合预期
        for (int i = list.size()-1; i >= 0 ; i--) {
            list.remove(i);
        }
        System.out.println("for循环倒序遍历移除元素结果：" + list);

        //forEach  报错  https://blog.csdn.net/baidu_39298625/article/details/122846653
        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        for (Integer integer : list) {
            list.remove(integer);
        }
        System.out.println("foreach循环遍历移除元素结果：" + list);
    }
}
