/*
*
*JAVA Basics 4
*Assignment 3
* John Crume
* 9/2/2021
*/


import java.util.ArrayList;

public class Assignment3 {

    public static void main(String args[]) {
        ArrayList<Integer> boundedBuffer = new ArrayList<Integer>();
        int size = 20;
        Thread prodThread = new Thread(new Producer(boundedBuffer, size), "Producer");
        Thread consThread = new Thread(new Consumer(boundedBuffer, size), "Consumer");
        prodThread.start();
        consThread.start();
    }
}

//producer class that adds integers to buffer
class Producer implements Runnable {

    private final ArrayList<Integer> boundedBuffer;
    private final int SIZE;

    public Producer(ArrayList<Integer> bbf, int size) {
        this.boundedBuffer = bbf;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
                //Thread.sleep(30);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        //wait if buffer is full
        while (boundedBuffer.size() == SIZE) {
            synchronized (boundedBuffer) {
                System.out.println("Buffer is full " + Thread.currentThread().getName()
                                    + " is waiting , size: " + boundedBuffer.size());

                boundedBuffer.wait();
            }
        }

        //producing element and notify consumer
        synchronized (boundedBuffer) {
            boundedBuffer.add(i);
            boundedBuffer.notifyAll();
        }
    }
}

//consumer that removes integers from buffer
class Consumer implements Runnable {

    private final ArrayList<Integer> boundedBuffer;
   

    public Consumer(ArrayList<Integer> bbf, int size) {
        this.boundedBuffer = bbf;
        //this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if buffer is empty
        while (boundedBuffer.isEmpty()) {
            synchronized (boundedBuffer) {
                System.out.println("Buffer is empty " + Thread.currentThread().getName()
                                    + " is waiting , size: " + boundedBuffer.size());

                boundedBuffer.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (boundedBuffer) {
        	boundedBuffer.notifyAll();
            return (Integer) boundedBuffer.remove(0);
        }
    }
}
