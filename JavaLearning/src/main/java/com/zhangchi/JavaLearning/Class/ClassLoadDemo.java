package com.zhangchi.JavaLearning.Class;

class Super{
    //public static int m = 11;
    static{
        System.out.println("执行了super类静态语句块");
    }
}

class Father extends Super{
    public static int a = 1;
    public static int m = 33; // 如果注释掉 Father 类中对 m 定义的那一行
    static{
        System.out.println("执行了父类静态语句块");
    }
    static{
        a = 2;
    }

    Father(){
        System.out.println("Father constructor");
    }
}

class Child extends Father{
    public static int b = a;
    static{
        System.out.println("执行了子类静态语句块");
    }
    Child(){
        System.out.println("Child constructor");
    }
}

//public class ClinitTest{
//
//}

/**
 * （）方法与实例构造器()方法（类的构造函数）不同，它不需要显式地调用父类构造器，虚拟机会保证在子类的()方法执行之前，父类的()方法已经执行完毕。
 */
public class ClassLoadDemo {
    public static void main(String[] args){
        //System.out.println(Child.b);
        System.out.println(Child.m);
    }
}
