package com.bmc.practice.Threading;

/*
 * Example of wait and notify methods.
 */
class ThreadB extends Thread {
	
	int total=0;
	
	public void run() {
		synchronized(this) {
			System.out.println("Child thread starting calculation");			
			for (int i=1; i<=100; i++)
				total=total+i;
			System.out.println("Child thread calculation done!! notify main method");
			this.notify();
		}
	}
	
}

public class WaitNotifyExample {
	
	public static void main (String[] args) {
		ThreadB t = new ThreadB();
		t.start();
		
		//Thread.sleep(10000); // if child executed first and main later then wait will never be notified
		
		synchronized(t) {
			System.out.println("Main thread trying to call wait() method");
			try {
				t.wait();
				//t.wait(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Main thread got notification");
			System.out.println("total is "+t.total);
		}		
	}
}
