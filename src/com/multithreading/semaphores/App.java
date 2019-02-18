package com.multithreading.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Library analogy - Suppose a library has 10 identical study rooms, to be used by one student at a time. To prevent a dispute the student must request
 * a room from front desk if they wish to make use of study room. If no rooms are free student wait at the front desk until someone relinquish a room.
 * When student wish to finish using a room, the student must return to the desk and indicate the room has become free.
 *
 * Note : Semaphore tracks only how many resource are free, it does not keep track which of the resources are free!!
 *        The semaphore count may serve as a useful trigger for a number of different actions
 *        Producer consumer problem can be implemented using semaphore
 *
 * How to Use:
 *  Semaphore maintains a set of permits
 *   - acquire() If permit is available then take it
 *   - release() adds a permits
 */

enum Downloader {
    INSTANCE;

    private Semaphore semaphore = new Semaphore(3, true);

    public void downloadData() {
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void download() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        System.out.println("Downloading data from web..");
    }
}
public class App {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0 ;i < 12; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    Downloader.INSTANCE.downloadData();
                }
            });
        }
    }
}
