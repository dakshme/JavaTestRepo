package com.bmc.practice.concurrent.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Program to demonstrate how ConcurrentModificationException will not occur in case of ConcurrentHashMap.
 */

public class ConcurrentHashMapExample1 extends Thread {

	public static ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
	
	public static void main(String[] args) throws InterruptedException {
		map.put("AAA",10);
		map.put("BBB",20);
		map.put("CCC",30);
		map.put("DDD",40);
		
		//launch thread now
		ConcurrentHashMapExample1 thread = new ConcurrentHashMapExample1();
		thread.start();

		Thread.sleep(3000); //let thread put new entry in map
		Set<Object> s1 = map.keySet();
		
		Iterator<Object> itr = s1.iterator();
		
		while(itr.hasNext()) {
			System.out.println("Main Thread iterating map: "+map.get(itr.next()));
			Thread.sleep(3000);
		}		
	}
	
	public void run() {
		//another thread try to add object to it.
		System.out.println("Inside thread, add element to List now.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { 	e.printStackTrace(); 	}
		ConcurrentHashMapExample1.map.put("EEEE",50);
	}


	
}
