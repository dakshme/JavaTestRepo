package com.bmc.practice.Thread.Daemon;

/*
 * Example to show if all non-deamon thread terminates then automatically all daemon threads also exits.
 */

public class DaemonThreadExample2 {

	public static void main(String[] args ) {

		MyTestThread t = new MyTestThread(); //using the same thread class from DaemonThreadExample1		
		
		//set my test thread to daemon
		t.setDaemon(true); // If we comment this i.e. leave the thread as non-daemon then thread
						   // will continue even after main exits. But if its daemon it immediately terminates
						   // as main ends.
		
		t.start(); // start execution of thread
		
		System.out.println("exiting main thread");
	}
	
}
