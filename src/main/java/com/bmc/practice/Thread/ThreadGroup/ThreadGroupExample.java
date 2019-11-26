package com.bmc.practice.Thread.ThreadGroup;

/*
 * Every thread in java under some group. Main thread group name is main.
 * And every thread group has parent group as well. system group is the top most thread group.
 */

public class ThreadGroupExample {

	public static void main(String[] args) {
		System.out.println("Main thread group name is "+Thread.currentThread().getThreadGroup().getName());
		//Thread.currentThread()  ==> main thread
		//getThreadGroup()  ==> main thread group
		//getName()  ==> get group name
		
		System.out.println("Main thread group parent group name is "+Thread.currentThread().getThreadGroup().getParent().getName());
		//Thread.currentThread()  ==> main thread
		//getThreadGroup()  ==> main thread group
		//getParent()   ==> get parent group
		//getName()  ==> get parent group name
	}
}
