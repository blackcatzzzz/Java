package com.zhangchi.JavaLearning.Thread;

class TestWait extends Thread{

    TestWait(String s){
        super(s);
    }

    public void run(){
        System.out.println("线程 "+ this.getName() + "开始运行。。。");
        synchronized (this){
            try {
                wait(10000);
            } catch (InterruptedException e) {
                System.out.println(this.isInterrupted());
            }
        }
    }
}


public class TestInterrupte {
    public static void main(String[] args) {
        TestWait tw = new TestWait("TestWait");
        //tw.setName("TestWait");
        tw.start();
        System.out.println("打断线程 "+ tw.getName());
        tw.interrupt();
    }
}
