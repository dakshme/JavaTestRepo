package com.bmc.practice.concurrentPackage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer Consumer Problem solution using BlockingQueue in Java.
 * BlockingQueue not only provide a data structure to store data
 * but also gives you flow control, require for inter thread communication.
 * 
 */
public class ProducerConsumerSolution {

    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();
        
        ProducerThread p = new ProducerThread(sharedQ);
        ConsumerThread c = new ConsumerThread(sharedQ);
        
        p.start();
        c.start();
    }
}

class ProducerThread extends Thread {
    private BlockingQueue<Integer> sharedQueue;

    public ProducerThread(BlockingQueue<Integer> aQueue) {
        super("PRODUCER");
        this.sharedQueue = aQueue;
    }

    public void run() {
        // no synchronization needed
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(getName() + " produced " + i);
                sharedQueue.put(i);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class ConsumerThread extends Thread {
    private BlockingQueue<Integer> sharedQueue;

    public ConsumerThread(BlockingQueue<Integer> aQueue) {
        super("CONSUMER");
        this.sharedQueue = aQueue;
    }

    public void run() {
        try {
            while (true) {
                Integer item = sharedQueue.take();
                System.out.println(getName() + " consumed " + item);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}