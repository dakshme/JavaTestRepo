package com.bmc.practice.Threading;

/*
 * Join example where child thread waiting for main thread to complete.
 * Here the child thread should have the reference of main thread object to call join on it.
 * Need to keep it static in child thread class
 */
public class ThreadJoinDemo1 {

	public static void main (String[] args) {	
		//setting main thread object as reference to child thread
		ThreadTest1.mainThread = Thread.currentThread();
		
		ThreadTest1 t = new ThreadTest1();
		t.start();
		
		for (int i=0; i<10; i++)
			System.out.println("Main Thread");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Now exiting Main Thread");
	}
}

class ThreadTest1 extends Thread {
	
	static Thread mainThread;
	
	public void run() {
		//calling join in main thread object
		try {
			mainThread.join();
		}
		catch (InterruptedException e) { }
		
		for(int i=0; i<10; i++) {
			System.out.println("After Main Child Thread");
		
		}
	}
}