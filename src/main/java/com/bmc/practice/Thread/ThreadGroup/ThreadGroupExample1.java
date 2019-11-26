package com.bmc.practice.Thread.ThreadGroup;

/*
 * Setting thread group max priority
 * 
 */

public class ThreadGroupExample1 {

	public static void main(String[] args) {
		ThreadGroup g1 = new ThreadGroup("New Group"); //thread group default max priority is 10
		
		Thread t = new Thread(g1, "Thread 1"); //default thread priority is 5.
		Thread t1 = new Thread(g1, "Thread 2");
		g1.setMaxPriority(3); //setting the max priority to 3
		Thread t2 = new Thread(g1, "Thread 3"); // this thread priority is 5 being added to group having max priority 3 so thread will be added as 3 priority
		
		//the priority of thread t and t1 will remain as 5 and wont be changed

		System.out.println(t.getPriority()); //5
		System.out.println(t1.getPriority());//5
		System.out.println(t2.getPriority());//3
		
	}

}
