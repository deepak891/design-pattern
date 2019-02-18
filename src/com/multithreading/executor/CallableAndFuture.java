package com.multithreading.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Worker1 implements Callable<String> {

    private int id;

    public Worker1(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Id :" + id;
    }
}

public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<String>> list = new ArrayList<>();

        for (int i = 0 ; i < 5;i++) {
            Future<String> future = executorService.submit(new Worker1(i+1));
            list.add(future);
        }

        for(Future<String> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}
