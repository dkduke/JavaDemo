package com.duke.boot.asm;

import java.lang.management.ManagementFactory;

/**
 * @author: dengkun11
 * @date: 2022/09/01
 * @description: 将Base类做改写，在其中编写main方法，每五秒调用一次process()方法，在process()方法中输出一行“process”。
 * 我们的目的就是，在JVM运行中的时候，将process()方法做替换，在其前后分别打印“start”和“end”。
 */
public class BaseNew {

    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    public static void process() {
        System.out.println("process");
    }

}
