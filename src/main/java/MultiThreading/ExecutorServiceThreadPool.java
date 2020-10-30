package MultiThreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{

    private String message;

    public WorkerThread(String message) {
        this.message = message;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);
        processMessage();
        System.out.println(Thread.currentThread().getName()+" (End)");

    }

    private void processMessage() {

        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
    }
}

public class ExecutorServiceThreadPool {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
            Runnable workerTh = new WorkerThread(" "+i);
            ex.execute(workerTh);
        }
        ex.shutdown();
        while(!ex.isTerminated()){

        }
        System.out.println("********All threads are Finished********");
    }



}
