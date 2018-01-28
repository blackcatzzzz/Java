package com.zhangchi.JavaLearning.Thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

class R implements Runnable{

    private int i;
    private Object obj;
    {
        System.out.println(i);
    }
    R(int i, Object obj){
        this.i = i;
        System.out.println(i);
        this.obj = obj;
    }

    public void run(){
        try{
            synchronized(obj){
                System.out.println("thread " + i + "wait...");
                obj.wait();
                System.out.println("thread " + i + "running...");
            }
        }catch (InterruptedException e){

        }
    }
}

public class TestNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread[] threads = new Thread[10];
        for (int i = 1; i < 10; ++i){
            threads[i] = new Thread(new R(i, obj));
        }

        for (int i = 1; i < 10; ++i){
            threads[i].start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj){
            obj.notifyAll(); // 通知所有因调用该对象实例的wait()方法的线程，放弃等待，开始逐一竞争锁
        }
    }
}
