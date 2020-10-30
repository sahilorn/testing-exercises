package MultiThreading;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        Worker first = new Worker(1000, countDownLatch, "worker-1");
        Worker second = new Worker(2000, countDownLatch, "worker-2");
        Worker third = new Worker(3000, countDownLatch, "worker-3");

        first.start();
        second.start();
        third.start();

        countDownLatch.await();
        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                " has finished");
    }

    private static class Worker extends Thread {

        private int delay;
        private CountDownLatch countDownLatch;

        public Worker(int time, CountDownLatch countDownLatch, String workerName) {
            this.delay = time;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()
                        + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
