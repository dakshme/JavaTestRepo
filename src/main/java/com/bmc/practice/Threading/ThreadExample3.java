package com.bmc.practice.Threading;

/*
 * Overriding start() method of Thread class in thread implementing class. 
 * start method used to launch and call run().
 */

class Test extends Thread{
	
	//overriding start() method itself
	public void start() {
		// because if this super call it call Thread class start() and hence can launch thread by calling run()
		super.start();
		System.out.println("start() method override "+Thread.currentThread().getName());
	}
	
	public void run( ) {
		System.out.println("Thread run method implementation "+ Thread.currentThread().getName());
	}

}

public class ThreadExample3 {
	
	public static void main (String[] args ) {
		Test t = new Test();
		t.start(); //child start() will be given priority and executed and hence no launch of thread will happen.
		System.out.println("main method");
	}
}
