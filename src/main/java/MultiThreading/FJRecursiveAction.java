package MultiThreading;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FJRecursiveAction {

    static final int SIZE = 10_000_000;
    static int[] array = randomArray();

    public static void main(String[] args) {
        int number = 9;
        System.out.println("First 10 elements of the array before: ");
        print();

        ArrayTransform mainTask = new ArrayTransform(array, number, 0, SIZE);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);

        System.out.println("First 10 elements of the array after: ");
        print();
    }

    private static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }


    public static int[] randomArray() {
        int[] array = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }


    public static class ArrayTransform extends RecursiveAction {

        int[] array;
        int number;
        int threshold = 100_000;
        int start;
        int end;

        public ArrayTransform(int[] array, int number, int start, int end) {
            this.array = array;
            this.number = number;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < threshold) {
                computeDirectly();

            } else {
                int middle = (end + start) / 2;
                ArrayTransform task1 = new ArrayTransform(array, number, start, middle);
                ArrayTransform task2 = new ArrayTransform(array, number, middle, end);
                invokeAll(task1, task2);
            }


        }

        private void computeDirectly() {
            for (int i = start; i < end; i++) {
                array[i] = array[i] * number;
            }
        }
    }
}
