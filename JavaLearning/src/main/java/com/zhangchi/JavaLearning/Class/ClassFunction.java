package com.zhangchi.JavaLearning.Class;


import java.util.List;

class A{
    void foo(Integer a){
        System.out.println("Integer");
    }

    void foo(int a){
        System.out.println("int");
    }

    //http://wiki.jikexueyuan.com/project/java-vm/overwise.html（语法糖章节有谬误）
    // 返回值不同并不能使字节码层面方法重载
//    boolean foo(List<Integer> list){
//        System.out.println("List<Integer> ");
//        return true;
//    }

    int foo(List<String> list){
        System.out.println("List<String> ");
        return 0;
    }
}

public class ClassFunction {
    public static void main(String[] args) {
        A a = new A();
        Integer b = 2;
        int c = 3;
        a.foo(1);
        a.foo(b);
        a.foo(c);
    }
}
