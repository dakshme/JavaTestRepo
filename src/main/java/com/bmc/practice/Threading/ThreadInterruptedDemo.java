package com.bmc.practice.Threading;

public class ThreadInterruptedDemo {
	
	public static void main (String[] args) {
		MyChildThread t = new MyChildThread();
		t.start();
		t.interrupt();
		System.out.println("End of main thread");
	}
}

class MyChildThread extends Thread {
	public void run() {	
		try {
				while(true) {
					System.out.println("I am a lazy thread");
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
			System.out.println("I got interrupted now");
		
		}
	}
}

