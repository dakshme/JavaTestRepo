package com.bmc.practice.Threading;

/*
 * t.start() will always call the no arg run method to launch the thread. The other overloaded run() method
 * will be treated as normal method only.
 * 
 * If we not overriding the no args run() method from class then also t.start() will be executed successfully 
 * running the empty implementation from THread class.
 * 
 */

public class ThreadExample2 extends Thread {

	/*HERE NOT OVERRIDING THE run() method from Thread class
	 * 
	 */
	
	//overloading run() 
	public void run(int i) {
		System.out.println("int args run method overloaded");
	}

	public static void main(String[] args) {
		ThreadExample2 t = new ThreadExample2();
		t.start();
	}
	
}
