import java.util.concurrent.*;

class Worker implements Runnable {
    int id ;
    CyclicBarrier cyclicBarrier;
    public Worker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        doWork();
        try {

            cyclicBarrier.reset();
            System.out.println("Thread :" + id + " waiting for others...");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Can't wait... " + id);
        }
    }

    private void doWork() {
        System.out.println("Id :" + id + " Started working ....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
public class Main {
    public static void main(String[] argList)  {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Finished execution ... ");
            }
        });
        for(int i = 0 ; i < 3 ; i++) {
            executorService.submit(new Worker(i, cyclicBarrier));
        }

        executorService.shutdown();
    }
}
