package clearwater;

import java.util.PriorityQueue;

public class PREx {


    public static void main(String[] args) {
        PriorityQueue todo = new PriorityQueue();
        todo.add("dishes");
        todo.add("laun");
        todo.add("bills");
        todo.offer("bills");
        System.out.print(todo.size() + " " + todo.poll());
        System.out.print(todo.peek() + " " + todo.poll());
        System.out.println(" " + todo.poll() + " " + todo.poll());

    }
}
