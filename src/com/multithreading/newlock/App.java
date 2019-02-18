package com.multithreading.newlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *  - Same behaviour as synchronized approach
 *  - with additional benefit
 *  - We can check whether the given lock is held or not with reentrant lock
 *  - We can get list of thread waiting for the given lock with reentrant locks
 *
 *  new ReentrantLock(fairness parameter) - If fairness set to true longest waiting thread will get lock, hence prevent from thread starvation
 *
 *  IMPORTANT : We have to use try-catch block when doing critical section that may through exception.
 */
public class App {
    private static int COUNTER = 0;
    private static ReentrantLock lock = new ReentrantLock();

    private static void increment(){

        lock.lock();
        try{
            for(int i = 0;i<100000;i++)
                COUNTER++;
        }finally {
            lock.unlock();
        }


    }
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value : " + COUNTER);

    }
}
