package MultiThreading;

import java.util.List;

class WorkerExecutor implements Runnable{

    @Override
    public void run() {
        System.out.println(" running from "+Thread.currentThread().getName());
    }
}

public class MultiExecutor {

    private List<Runnable> tasks;

    // Add any necessary member variables here

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        for(Runnable task:tasks){
          Thread thread = new Thread(task);
          thread.start();
        }
    }

    public static void main(String[] args) {

        Runnable wk = new WorkerExecutor();
    }
}
