package com.bmc.practice.concurrent.collection;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * To demonstrate how iterator are are fail safe and
 * how exception raises if trying modifying collection object via 2 thread.
 * 
 * ConcurrentModificationException - THis is the common issue with the traditional collection
 * 
 * Exception in thread "main" java.util.ConcurrentModificationException
 *
 */

public class ConcurrentModificationExceptionDemo extends Thread {

	public static ArrayList<String> al = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		al.add("AAA");
		al.add("BBB");
		al.add("CCC");
		al.add("DDD");
		
		//launch thread now
		ConcurrentModificationExceptionDemo thread = new ConcurrentModificationExceptionDemo();
		thread.start();

		
		Iterator<String> itr = al.iterator();
		
		while(itr.hasNext()) {
			System.out.println("Main Thread "+itr.next());
			Thread.sleep(3000);
		}		
	}
	
	public void run() {
		//another thread try to add object to it.
		System.out.println("Inside thread, add element to List now.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { 	e.printStackTrace(); 	}
		ConcurrentModificationExceptionDemo.al.add("EEEE");
	}

}
