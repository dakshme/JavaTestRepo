package com.bmc.practice.Threading;

/*
 * Join example where main thread waiting for child thread to complete.
 */
public class ThreadJoinDemo {
	
	public static void main (String[] args) {
		ThreadTest t = new ThreadTest();
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i<10; i++)
			System.out.println("Main Thread");
		
		System.out.println("After join() Now exiting Main Thread");
	}

}

class ThreadTest extends Thread {
	
	public void run() {
		
		for(int i=0; i<10; i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) { }
		}
	}
}