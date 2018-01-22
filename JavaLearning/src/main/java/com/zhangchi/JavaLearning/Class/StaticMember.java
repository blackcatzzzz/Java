package com.zhangchi.JavaLearning.Class;

public class StaticMember{
    private static int a = 5;   // 1
    private static int b;   //2

    static{ //3
        System.out.println(a);
        System.out.println(b);
    }

    private static int c = 7; //4

    public static void main(String[] args){

    }
}