package com.designpattern.behavioral.command2;

/**
 * Command package a piece of execution ... this computation may be invoked long after the command object is created.
 *
 * - it can be invoked by different threads !!!
 * - schedules, thread pools, job queues ...
 */
public class App {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();

        Thread t1 = new Thread( () -> algorithm.produce());

        Thread t2 = new Thread( () -> algorithm.consume());

        t1.start();
        t2.start();
    }
}
