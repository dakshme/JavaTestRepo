package com.bmc.practice.concurrentPackage;

/*
 * CountDownLatch Example.
 * Note: CountDownLatch can not be reused. That is once its value reached 0 it can not be rest back.
 * Hence once await() method called. Calling it again will have to effect.
 */

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String args[])  throws InterruptedException {
	 
	 // Let us create task that is going to  wait for four threads before it starts 
	 CountDownLatch latch = new CountDownLatch(4); 

	 // Let us create four worker  threads and start them. 
	 Worker first = new Worker(1000, latch, "WORKER-1"); 
	 Worker second = new Worker(2000, latch, "WORKER-2"); 
	 Worker third = new Worker(1000, latch, "WORKER-3"); 
	 Worker fourth = new Worker(1000, latch, "WORKER-4");
	 
	 first.start(); 
	 second.start(); 
	 third.start(); 
	 fourth.start(); 
	
	 // The main task waits for four threads 
	 latch.await();
	 // Main thread has started 
	 System.out.println(Thread.currentThread().getName() + " has finished"); 
	}
}

//A class to represent threads for which the main thread waits. 
class Worker extends Thread 
{ 
 private int delay; 
 private CountDownLatch latch; 

 public Worker(int delay, CountDownLatch latch, String name) { 
     super(name); 
     this.delay = delay; 
     this.latch = latch; 
 }

 @Override
 public void run() 
 { 
     try { 
         Thread.sleep(delay);  
         System.out.println(Thread.currentThread().getName() + " finished");
         latch.countDown();
     } 
     catch (InterruptedException e) {    e.printStackTrace();    } 
 } 
} 
