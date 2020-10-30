package MultiThreading.ProducerConsumerExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class PCUsingCountDownLatch {

    public static class Producer implements Runnable {

        private List<Integer> queue;
        private CountDownLatch latch;
        private int next = 0;

        public Producer(List<Integer> queue, CountDownLatch latch) {
            this.queue = queue;
            this.latch = latch;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    System.out.println("Next Number --> " + next);
                    queue.add(next);
                    latch.countDown();
                }
                next++;
            }
        }
    }

    public static class Consumer implements Runnable {

        private List<Integer> queue;
        private CountDownLatch latch;

        public Consumer(List<Integer> queue, CountDownLatch latch) {
            this.queue = queue;
            this.latch = latch;
        }

        @Override
        public void run() {
            while (true) {
                Integer number = null;
                synchronized (queue) {
                    if (queue.size() > 0) {
                        number = queue.remove(queue.size() - 1);
                        System.out.println("Number Removed -->" + number);
                    }
                }
                if (number == null) {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> queue = new ArrayList<Integer>();
        CountDownLatch latch = new CountDownLatch(1);
        Thread producer1 = new Thread(new Producer(queue, latch));
        Thread consumer1 = new Thread(new Consumer(queue, latch));
        producer1.start();
        consumer1.start();
    }

}
