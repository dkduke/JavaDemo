package com.duke.boot.asm;

import javassist.*;

import java.io.IOException;

/**
 * @author: dengkun11
 * @date: 2022/09/01
 * @description: 强调源代码层次操作字节码的框架Javassist
 */

public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException,
            InstantiationException, IOException {

        //Base b = new Base();  即在增强前就先让JVM加载Base类，然后在执行到c.toClass()方法时会抛出错误, 即JVM是不允许在允许时动态重载一个类的

        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.duke.boot.asm.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start \"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/dengkun11/Documents/Jcode/learn/bootfirst/src/main/java/com/duke/boot/asm");
        Base h = (Base) c.newInstance();
        h.process();
    }
}
