package com.zhangchi.JavaLearning.Class;

public class StaticMember{
    private static int a = 5;   // 1
    private static int b;   //2

    static{ //3
        System.out.println(a);
        System.out.println(b);
    }

    private static int c; //4

    public static final int d = 1;

    public final int e;

    StaticMember(){
        e = 2;
    }

    public static void A(){
        System.out.println("StaticMember A");
    }

    public static void main(String[] args){
        StaticMember.A();
    }
}

class B extends StaticMember{
    public static void A(){
        System.out.println("B A");
    }
}