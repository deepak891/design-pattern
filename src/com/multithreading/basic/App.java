package com.multithreading.basic;

class Runnner1 implements Runnable{
 /*   public void startRunning() {
        for(int i = 0 ; i< 10 ; i++) {
            System.out.println("Runner1 = " + i);
        }
    }
*/
    @Override
    public void run() {
        for(int i = 0 ; i< 10 ; i++) {
            System.out.println("Runner1 = " + i);
        }
        System.out.println("Runner 1 task done");
    }
}

class Runner2 extends Thread{

    @Override
    public void run() {
        for(int i = 0 ; i< 10 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner2 = " + i);
        }
        System.out.println("Runner2 task done");
    }
}


public class App {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnner1());
        Runner2 runner2 = new Runner2();

        t1.start();
        runner2.start();

        try {
            runner2.join(); //until runner2 is not finished main thread will not cross this point
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished task...");
    }
}
