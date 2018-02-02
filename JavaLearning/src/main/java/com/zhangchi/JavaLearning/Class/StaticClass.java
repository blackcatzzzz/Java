package com.zhangchi.JavaLearning.Class;

/**
 * @author Chi Zhang
 * @date 2018/2/2
 */
public class StaticClass {
    private int a = 1;
    private static int b = 2;

    public void foo(){
        System.out.println(SA.d);
    }

    private static class SA{
        private int c = 3;
        private static int d = 4;

        static {
            System.out.println(b);
        }

        SA(){
            System.out.println("SA construct");
        }

        void foo(){
            //System.out.println(a); // 不能访问外部类的非静态成员
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        StaticClass demo = new StaticClass();
        demo.foo();
        //System.out.println();
    }
}
