package com.bmc.practice.Thread.ThreadGroup;

public class ThreadGroupEnumerate {

	public static void main(String[] args) {
		
		//getting system thread group reference.
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		
		Thread[] t = new Thread[system.activeCount()];
		
		system.enumerate(t);
		
		for(Thread t1 : t) {
			System.out.println(t1.getName()+"......."+t1.isDaemon());
			
		}
	}
}
