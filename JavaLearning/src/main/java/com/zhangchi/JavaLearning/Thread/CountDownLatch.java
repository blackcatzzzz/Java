package com.zhangchi.JavaLearning.Thread;

/**
 * CountDownLatch 简易实现，用于理解原理
 * @author Chi Zhang
 * @date 2018/1/29
 */
public class CountDownLatch {

    private int count;
    private Object myLock = new Object();

    public CountDownLatch(int count){
        this.count = count;
    }

    public void countDown(){
        synchronized (myLock){
            --count;
            if (count == 0)
                myLock.notifyAll();
        }
    }

    public void await(){
        synchronized (myLock){
            while (count > 0){
                try {
                    myLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class CountDownThread implements Runnable{

        private CountDownLatch countDownLatch;

        public CountDownThread(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        public void run(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " CountDown");
            countDownLatch.countDown();
        }

        public void start(String name){
            Thread t = new Thread(this, name);
            t.start();
        }

    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new CountDownThread(countDownLatch).start("1");
        new CountDownThread(countDownLatch).start("2");
        new CountDownThread(countDownLatch).start("3");

        System.out.println("CountDown wait...");
        countDownLatch.await();
        System.out.println("CountDown completed");
    }
}
