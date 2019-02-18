package com.multithreading.waitnotify;

class Processor {
    public void producer() throws InterruptedException {

        synchronized (this) {
            System.out.println("We are in producer ..");
            wait();
            System.out.println("Again in Producer ..");
        }
    }
    public void consumer() throws InterruptedException {
        Thread.sleep(3000);
        synchronized (this) {
            System.out.println("We are in consumer...");
            notify();
            Thread.sleep(3000);
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
