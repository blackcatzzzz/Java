package com.zhangchi.JavaLearning.Class;

/**
 * @author Chi Zhang
 * @date 2018/2/2
 */
public class ClassPrivilegeDemo {
    int defaultA = 1;
    protected int protecteB = 2;

    public static void main(String[] args) {
        ChildA ca = new ChildA();
        ca.print();
    }
}

class ChildA extends ClassPrivilegeDemo{
    void print(){
        System.out.println(defaultA);
    }
}
class ChildB extends ClassPrivilegeDemo{
    void print(){
        System.out.println(protecteB);
    }
}

