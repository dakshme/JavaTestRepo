package com.bmc.practice.concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		ConcurrentHashMap<Object, Object> cm = new ConcurrentHashMap<>();
		cm.put(101, "Mahesh");
		cm.put(102, "Daksha");
		System.out.println(cm);  // {101=Mahesh, 102=Daksha}
		cm.putIfAbsent(101, "Kumar"); // this will NOT be inseterd in to the Map
		System.out.println(cm);  // {101=Mahesh, 102=Daksha}
		
		//remove
		cm.remove(101, "Kumar");
		System.out.println(cm);  // {101=Mahesh, 102=Daksha}
	}
}
