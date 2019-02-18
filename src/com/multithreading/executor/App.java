package com.multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 1. ExecutorService service = Executors.newCachedThreadPool()
 *     - Going to return executor service that can dynamically reuse threads.
 *     - Before starting a Job - it is going to check if there any thread that finished the job .. reuse them.
 *     - If there is no waiting thread it is going to create a new thread
 *
 * 2. ExecutorService service = Executors.newFixedThreadPool(n)
 *     - n number of threads will be created
 *     -If there is no thread in pool then, new task has to wait for a thread to get free
 *
 * 3. ExecutorService service = Executors.newSingleThreadExecutor()
 *      - Single thread will be created
 *
 */
public class App {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 5 ; i++) {
            service.submit(new Worker());
        }
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        for(int i = 0 ; i < 100 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
