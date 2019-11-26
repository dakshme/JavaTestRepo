package com.bmc.practice.Threading;

public class MyRunnableThread implements Runnable {
	
		//Job of a thread
		public void run () { // executed by child thread
		for(int i=0; i<10; i++)
		   System.out.println("Child Thread");
	}

	public static void main (String[] args) {
		MyRunnableThread r = new MyRunnableThread();
		Thread t = new Thread(r); // here object ‘r’ is target runnable.
		t.start();
		System.out.println("Still parent Thread");
	}
}
