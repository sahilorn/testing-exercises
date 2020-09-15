package MultiThreading;

public class JoinExample extends Thread {

    private String message;

    public JoinExample(String message) {
        this.message = message;
    }

    public void run() {

        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " again");
    }

    public static void main(String[] args) {
        JoinExample t1 = new JoinExample("first thread");
        JoinExample t2 = new JoinExample("second thread");
        t1.start();

        try {
            t1.join(1500);      //Waiting for t1 to finish
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }

        t2.start();

        try {
            t2.join(1500);      //Waiting for t2 to finish
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }


}
