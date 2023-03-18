package com.duke.boot.asm;

/**
 * @author: dengkun11
 * @date: 2022/09/01
 * @description: 需要被增强的base类
 *  https://www.jianshu.com/p/a6286040656c
 *
 *   为了利用ASM实现AOP，需要定义两个类：一个是MyClassVisitor类，用于对字节码的Visit以及修改；
 *   另一个是Generator类，在这个类中定义ClassReader和ClassWriter，
 *   其中的逻辑是，classReader读取字节码，然后交给MyClassVisitor类处理，处理完成后由ClassWriter写字节码并将旧的字节码替换掉。
 *   Generator类较简单，我们先看一下它的实现，如下所示，然后重点解释MyClassVisitor类。
 *
 */
public class Base {

    public void process() {
        System.out.println("process");
    }

}
