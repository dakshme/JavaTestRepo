package com.bmc.practice.collection.list;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<Object> l = new LinkedList<>();
		l.add("Mahesh");
		l.add(null);
		l.add("Marsh");
		l.add(30);
		System.out.println(l); // [Mahesh, null, Marsh, 30]
		
		l.set(0,"TimePass");
		System.out.println(l); // [TimePass, null, Marsh, 30]
		
		l.add("Night");
		System.out.println(l); // [TimePass, null, Marsh, 30, Night]
		
		l.removeLast();
		l.addFirst("AAAA");
		System.out.println(l); // [AAAA, TimePass, null, Marsh, 30]

	}

}
