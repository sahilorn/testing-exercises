package MultiThreading;

public class DataRaceExample {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedResource.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedResource.check();
            }
        });
        t1.start();
        t2.start();
    }

    public static class SharedResource {

        private volatile int x = 0;
        private volatile int y = 0;

        private void increment() {
            //System.out.println("incrementing");
            x++;
            y++;
        }

        private void check() {
            if (y > x) {
                System.out.println(" y > x  Data Race occurred");
            }
            if (x > y) {
                System.out.println("x > y Data Race occurred");
            }
        }
    }


}




