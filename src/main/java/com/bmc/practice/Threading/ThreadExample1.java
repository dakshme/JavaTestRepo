package com.bmc.practice.Threading;

/*
 * t.start() will always call the no arg run method to launch the thread. The other overloaded run() method
 * will be treated as normal method only.
 * 
 */

public class ThreadExample1 extends Thread {
	
	//overriding Thread class run ()
	public void run() {
		System.out.println("no args run method overriding from Thread class");
	}
	
	//overloading run() 
	public void run(int i) {
		System.out.println("int args run method overloaded");
	}

	public static void main(String[] args) {
		ThreadExample1 t = new ThreadExample1();
		t.start();
	}
	
}
