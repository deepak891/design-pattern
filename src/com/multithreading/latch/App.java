package com.multithreading.latch;

/**
 * This is used to synchronize one or more task by forcing them to wait for the completion of a set of operation.
 * - You give initial count to the CountDownLatch, and any task that calls await on the object will block untill the count reaches 0.
 * - Other task may call countDown() on the object to reduce the count,
 *
 *
 */
public class App {
}
