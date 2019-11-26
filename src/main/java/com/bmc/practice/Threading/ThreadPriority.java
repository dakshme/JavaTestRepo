package com.bmc.practice.Threading;

public class ThreadPriority extends Thread {
	public void run() {
		for (int i = 0; i<10; i++)
		{
			System.out.println("child Thread "+Thread.currentThread().getPriority());
			if (5==i)
				Thread.currentThread().setPriority(3);
		}
	}
	
	public static void main(String[] args) {
		ThreadPriority t = new ThreadPriority();
		t.setPriority(MAX_PRIORITY); // child thread priority set to max
		t.start();
		
		//parent/main thread resume here
		for (int i = 0; i<10; i++)
		{
			System.out.println("Main Thread "+Thread.currentThread().getPriority());
		}
	}

}
