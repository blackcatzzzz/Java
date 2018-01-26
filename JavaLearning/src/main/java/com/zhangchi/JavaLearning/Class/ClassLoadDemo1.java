package com.zhangchi.JavaLearning.Class;

class Base {

    Base() {
        preProcess();
    }

    void preProcess() {
        System.out.println("preProcess in Base");
    }

    void preProcess(int a) {
        System.out.println("preProcess in Base");
    }
}

class Derived extends Base {

    public String whenAmISet = "set when declared";

    //@Override
    void preProcess() {

        System.out.println("preProcess in Derived");
        whenAmISet = "set in preProcess";
    }

}

public class ClassLoadDemo1 {

    public static void main(String[] args) {
        Derived d = new Derived();
        System.out.println(d.whenAmISet);
    }
}
