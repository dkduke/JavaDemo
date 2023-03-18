package com.dk.constant;

/**
 * @author: dengkun11
 * @date: 2022/09/14
 * @description: static执行顺序
 */
public class StaticSequence {

    //private static StaticSequence t = new StaticSequence();
    public static String a = "qwe";
    public int d = 666;

    static{
        System.out.println("static A: "+StaticSequence.a);
        StaticSequence.a = "2";
        System.out.println("static A: "+StaticSequence.a);
        System.out.println("static B: "+StaticSequence.b);
        StaticSequence.b = "4";
        System.out.println("static B: "+StaticSequence.b);
    }
    private static String b = "asd";

    private StaticSequence(){
        System.out.println("Constructor");
        System.out.println("Constructor A: "+StaticSequence.a);
        System.out.println("Constructor B: "+StaticSequence.b);
    }
    public int e = 888;

    public static void start(){
        System.out.println("start() method A: "+StaticSequence.a);
        System.out.println("start() method B: "+StaticSequence.b);
    }

    public static void main(String[] args){
        StaticSequence t = new StaticSequence();
        start();
        //StaticSequence.start();
    }

}
