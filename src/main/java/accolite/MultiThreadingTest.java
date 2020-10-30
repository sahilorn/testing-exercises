package accolite;

public class MultiThreadingTest {

    public static void main(String[] args) {

    }

    private static class ThreadClass implements  Runnable{

        static int number_upto =10;
        static int number = 1;
        int remainder;
        static Object lock = new Object();

        public ThreadClass(int remainder) {
            this.remainder = remainder;
        }

        @Override
        public void run() {
            while(number < number_upto -1){
                synchronized (lock){
                    while(number%3 != remainder){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        number++;
                        lock.notifyAll();
                    }
                }
            }

        }
    }

}
