package MultiThreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FJRecursiveTask {

    static final int SIZE = 10_000_000;
    static int[] array = randomArray();

    public static void main(String[] args) {
        System.out.println("available processors" + Runtime.getRuntime().availableProcessors());
        ArrayCounter mainTask = new ArrayCounter(array, 0, SIZE);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        Integer evenNumberCount = pool.invoke(mainTask);
        System.out.println("pool size " + pool.getParallelism());
        InnerRunnableClass inr = new InnerRunnableClass();
        pool.execute(inr);
        InnerCallableClass inc = new InnerCallableClass();
        ForkJoinTask<String> fjTask = pool.submit(inc);
        System.out.println(fjTask.join());

        System.out.println("Number of even numbers: " + evenNumberCount);

    }

    private static class InnerRunnableClass implements Runnable {

        @Override
        public void run() {
            System.out.println(" Inside runnable method");
        }
    }

    private static class InnerCallableClass implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Inside Callable Class";
        }
    }

    private static class ArrayCounter extends RecursiveTask<Integer> {

        int[] array;
        int threshold = 100_000;
        int start;
        int end;


        public ArrayCounter(int[] array, int i, int size) {
            this.array = array;
            this.start = i;
            this.end = size;
        }

        @Override
        protected Integer compute() {
            if (end - start < threshold) {
                return computeDirectly();
            } else {
                int middle = (end + start) / 2;

                ArrayCounter subTask1 = new ArrayCounter(array, start, middle);
                ArrayCounter subTask2 = new ArrayCounter(array, middle, end);

                invokeAll(subTask1, subTask2);

                return subTask1.join() + subTask2.join();
            }


        }

        protected Integer computeDirectly() {
            Integer count = 0;

            for (int i = start; i < end; i++) {
                if (array[i] % 2 == 0) {
                    count++;
                }
            }

            return count;
        }
    }

    static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }
}
