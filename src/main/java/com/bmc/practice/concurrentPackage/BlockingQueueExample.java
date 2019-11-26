package com.bmc.practice.concurrentPackage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {

        BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) { 	e.printStackTrace(); 	}
	}
}

class Producer implements Runnable{

    protected BlockingQueue<Object> queue = null;

    public Producer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    protected BlockingQueue<Object> queue = null;

    public Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
