package com.bmc.practice.Threading;

/*
 * Thread stop method example. But we should not use stop() as its deprecated.
 */

public class StopThread {

	public static void main(String[] args) {

		MyTestThread t = new MyTestThread();
		t.start();
		System.out.println("exiting main thread");
		t.stop();		
	}

}

class MyTestThread extends Thread {
	
	public void run() {
		
		for(int i = 1; i<=100; i++) {
			System.out.println("child thread loop count "+i);
			try {
				Thread.sleep(2000);  // 4sec sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
