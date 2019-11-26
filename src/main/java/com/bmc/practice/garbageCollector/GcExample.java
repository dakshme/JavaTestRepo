package com.bmc.practice.garbageCollector;

import java.util.Date;

/*
 * GArbage collector example using Runtime Object
 */

public class GcExample {

	public static void main(String[] args) {
	 
		Runtime r = Runtime.getRuntime();
		
		System.out.println("Total memory"+r.totalMemory());
		System.out.println("Free memory"+r.freeMemory());
		
		for(int i=0; i<10000; i++) {
			Date dt = new Date();
			dt = null;
		}
		
		System.out.println("Before GC Free memory"+r.freeMemory());
		r.gc();
		System.out.println("After GC Free memory"+r.freeMemory());

	}

}
