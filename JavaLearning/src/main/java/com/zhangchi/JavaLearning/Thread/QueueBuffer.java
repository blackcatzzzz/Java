package com.zhangchi.JavaLearning.Thread;

class Producer implements Runnable {

    private QueueBuffer q;

    Producer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }

}

class Consumer implements Runnable {

    private QueueBuffer q;

    Consumer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }

}

public class QueueBuffer {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        if (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }

    public static void main(String[] args) {
        QueueBuffer q = new QueueBuffer();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }
}