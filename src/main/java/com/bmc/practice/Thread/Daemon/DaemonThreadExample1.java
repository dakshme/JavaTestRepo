package com.bmc.practice.Thread.Daemon;

/*
 * Example to check if a thread is daemon and to toggle its state between daemon and non-daemon.
 */

public class DaemonThreadExample1 {

	public static void main(String[] args ) {
		
		System.out.println("Main thread is daemon: "+Thread.currentThread().isDaemon());
		
		//trying setting main thread as daemon will result into runtime exception
		//Thread.currentThread().setDaemon(true);  <== this will result in to R.E. Thread Illegal state
		
		MyTestThread t = new MyTestThread();
		
		System.out.println("My Test thread is daemon: "+t.isDaemon());
		
		//set my test thread to daemon
		t.setDaemon(true);
		t.start();
		
		System.out.println("Now My Test thread is daemon: "+t.isDaemon());
	}
}

class MyTestThread extends Thread {
	
	public void run() {
		
		for(int i = 0; i<=100; i++) {
			System.out.println("child thread loop count "+i);
			try {
				Thread.sleep(4000);  // 4sec sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
