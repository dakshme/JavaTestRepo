package com.bmc.practice.Threading;

/*
 * Example showing yield() call from thread giving opportunity to other thread to run.
 */

class MyThread extends Thread {
	
	public void run() {
		
		for(int i=0; i<5; i++) {
			System.out.println("Child Thread");
			//calling yield method
			Thread.yield();
		}
	}
}

public class ThreadYieldDemo {

	public static void main (String[] args) {
		MyThread t = new MyThread();
		t.start();
		
		for (int i=0; i<5; i++)
			System.out.println("Main Thread");
	}
}