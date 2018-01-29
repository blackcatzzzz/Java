package com.zhangchi.JavaLearning.Other;

// https://www.cnblogs.com/hyzxx/p/5151911.html
public class TryCatch {

    int test(){
        try {
            //int i  = 19 / 0;
            System.out.println("In Try...");
            return 1;
        }
        catch (Exception e){
            System.out.println("In catch...");
            System.out.println(e);
            return 2;
        }
        finally{
            System.out.println("In finally...");
            return 3;
        }
    }
    public static void test1(){
        System.out.println("In test1...");
    }

    public static void main(String[] args) {
        System.out.println(new TryCatch().test());
        new TryCatch().test1();
    }
}
