package MultiThreading.ProducerConsumerExamples;

import java.util.Vector;

public class PCUsingWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        ProducerWN producer = new ProducerWN();
        producer.start();
        Thread.sleep(100);
        new ConsumerWN(producer).start();
    }



}

class ProducerWN extends Thread{

    static final int MAX_QUEUE= 5;
    private Vector<String> messages = new Vector<String>();

    @Override
    public void run(){
        try{
            while(true){
                putMessages();
            }
        }catch(InterruptedException e){
            
        }

    }

    private synchronized void putMessages() throws InterruptedException {

        while(messages.size() == MAX_QUEUE){
            wait();
        }
        messages.addElement(new java.util.Date().toString());
        System.out.println("put message called");
        notify();
    }

    public synchronized String getMessage() throws InterruptedException {
        notify();
        while(messages.size() == 0){
            wait();
        }
        String messageOut = messages.firstElement();
        messages.removeElement(messageOut);
        return  messageOut;
    }
}

class ConsumerWN extends Thread{

    private ProducerWN producerWN;

    ConsumerWN(ProducerWN producerWN){
        this.producerWN = producerWN;
    }

    @Override
    public void run(){
        try{
            while(true){
                String message = producerWN.getMessage();
                System.out.println("Got message: " + message);
            }
        }catch (InterruptedException e){

        }
    }



}
