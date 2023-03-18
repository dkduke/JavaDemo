package com.duke.boot.asm;

//import jdk.internal.org.objectweb.asm.ClassReader;
//import jdk.internal.org.objectweb.asm.ClassVisitor;
//import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: dengkun11
 * @date: 2022/09/01
 * @description: 在这个类中定义ClassReader和ClassWriter
 */
public class Generator {

    public static void main(String[] args) throws Exception {
        //读取
//        ClassReader classReader = new ClassReader("com/duke/boot/asm/Base");
//        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//
//        // 处理
//        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
//        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
//        byte[] data = classWriter.toByteArray();
//
//        // 输出
//        //File f = new File("operation-server/target/classes/com/duke/boot/asm/Base.class");
//        File f = new File("/Users/dengkun11/Documents/Jcode/learn/bootfirst/src/main/java/com/duke/boot/asm/Base.class");
//        FileOutputStream fout = new FileOutputStream(f);
//        fout.write(data);
//        fout.close();
        System.out.println("now generator cc success!!!!!");

    }
}
