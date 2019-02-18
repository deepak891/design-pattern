package com.multithreading.producerconsumer;

import java.util.ArrayList;
import java.util.List;

class Processor {

    private List<Integer> list = new ArrayList<>();
    private final int LIMIT= 5;
    private final int BOTTOM = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if(list.size() == LIMIT) {
                    System.out.println("Waiting for removing item from list");
                    lock.wait();
                }else {
                    System.out.println("Adding value :" + value);
                    list.add(value);
                    value++;
                    lock.notifyAll();
                    Thread.sleep(1000);
                }
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while (true){
                if(list.size() == BOTTOM) {
                    System.out.println("Waiting item to be added");
                    lock.wait();
                }else {
                    System.out.println("Removed : " + list.remove(list.size()-1));
                    lock.notifyAll();
                    Thread.sleep(1000);
                }
            }
        }
    }
}

public class App {
    public static void main(String[] args) {

        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
