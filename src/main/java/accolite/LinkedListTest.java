package accolite;

import java.util.HashSet;

public class LinkedListTest {

    static Node head;

    private static class Node{
         int i;
         Node next;

         Node(int d){
             this.i = d;
         }

        @Override
        public String toString() {
            return "Node{" +
                    "i=" + i +
                    '}';
        }
    }

    public static void main(String[] args) {
            LinkedListTest linkedListTest = new LinkedListTest();

            linkedListTest.add(1);
            linkedListTest.add(2);
            linkedListTest.add(3);
            linkedListTest.add(5);
            linkedListTest.add(7);
            linkedListTest.add(3);

            linkedListTest.printList();

        System.out.println(isContainLoop(head));


    }

    private static boolean isContainLoop(Node head) {
        HashSet<Node> nodeSet = new HashSet<>();
        Node last = head;
        while(last.next != null){
            if(nodeSet.contains(head)){
                return true;
            }
            nodeSet.add(head);
            last = last.next;
        }
        return false;
    }

    private void add(int i) {
        Node new_node = new Node(i);
        new_node.next = null;
        if(head == null){
            head = new_node;
            return;
        }
        Node last = head;
        while(last.next != null){
                last= last.next;

        }
        last.next = new_node;
    }

    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.println("tnode " + tnode.toString());
            tnode = tnode.next;
        }
    }


}
