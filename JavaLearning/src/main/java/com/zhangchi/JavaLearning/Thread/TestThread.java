package com.zhangchi.JavaLearning.Thread;

class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;

    RunnableDemo(String threadName){
        this.threadName = threadName;
        System.out.println("Creating " +  threadName );
    }

    public void run(){
        System.out.println("Running " + threadName);

        for (int i = 4; i > 0; --i){
            System.out.println("Thread: " + threadName + ", " + i);
            try {
                // 让线程睡眠一会
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread " +  threadName + " interrupted.");
            }
        }

        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class TestThread{

    public static void testRunnableDemo(){
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();
    }

    public static void testThreadDemo(){
        ThreadDemo T1 = new ThreadDemo("Thread-3");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread-4");
        T2.start();
    }

    public static void main(String[] args){
        testRunnableDemo();
        testThreadDemo();
    }
}