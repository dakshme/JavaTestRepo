package com.bmc.practice.Thread.ThreadGroup;
/*
 * Creating of ThreadGroup using various contructor's
 */

public class CreateThreadGroup {

	public static void main(String[] args) {
		
		//1 constructor
		ThreadGroup g = new ThreadGroup("First Name");
		System.out.println(g.getParent().getName());
		
		//2 constructor
		ThreadGroup g1 = new ThreadGroup(g, "Second Name");
		System.out.println(g1.getParent().getName());
	}

}
