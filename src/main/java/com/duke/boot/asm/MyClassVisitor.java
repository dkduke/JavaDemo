package com.duke.boot.asm;

//import jdk.internal.org.objectweb.asm.ClassVisitor;
//import jdk.internal.org.objectweb.asm.ClassWriter;
//import jdk.internal.org.objectweb.asm.MethodVisitor;
//import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author: dengkun11
 * @date: 2022/09/01
 * @description: 用于对字节码的visit以及修改
 *
 * MyClassVisitor继承自ClassVisitor，用于对字节码的观察。
 * 它还包含一个内部类MyMethodVisitor，继承自MethodVisitor用于对类内方法的观察
 *
 */
public class MyClassVisitor
//        extends ClassVisitor implements Opcodes
{

//    public MyClassVisitor(ClassWriter cv) {
//        super(ASM5, cv);
//    }
//
//    /**
//     * 判断当前字节码读到哪一个方法了。跳过构造方法"<init>"后，将需要被增强的方法交给内部类MyMethodVisitor来进行处理
//     */
//    @Override
//    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
//        // Base类中有两个方法：无参构造以及process方法，这里不增强构造方法
//        if (!"<init>".equals(name) && mv != null) {
//            mv = new MyMethodVisitor(mv);
//        }
//        return mv;
//    }
//
//    class MyMethodVisitor extends MethodVisitor implements Opcodes {
//        public MyMethodVisitor(MethodVisitor mv) {
//            super(Opcodes.ASM5, mv);
//        }
//
//        /**
//         * visitCode方法，它会在ASM开始访问某一个方法的Code区时被调用，重写visitCode方法，将AOP中的前置逻辑就放在这里。
//         */
//        @Override
//        public void visitCode() {
//            super.visitCode();
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitLdcInsn("start...");
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//        }
//
//        /**
//         * MyMethodVisitor继续读取字节码指令，每当ASM访问到无参数指令时，都会调用MyMethodVisitor中的visitInsn方法。
//         * 我们判断了当前指令是否为无参数的“return”指令，如果是就在它的前面添加一些指令，也就是将AOP的后置逻辑放在该方法中。
//         */
//        @Override
//        public void visitInsn(int opcode) {
//            if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
//                // 方法在返回之前，打印"end..."
//                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//                mv.visitLdcInsn("end...");
//                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//            }
//            mv.visitInsn(opcode);
//        }
//    }
}
