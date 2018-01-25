package com.zhangchi.JavaLearning.designpattern;


class Singleton{
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (instance == null){
            synchronized(Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }

        return instance;
    }
}

// Initialization on Demand Holder（IODH）
class SingletonIODH{
    private SingletonIODH(){}

    private static class SingletonHolder{
        private static SingletonIODH instance  = new SingletonIODH();
    }

    public static SingletonIODH getInstance(){
        return SingletonHolder.instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        SingletonIODH s = SingletonIODH.getInstance();
    }
}
