package com.bmc.practice.collection.set;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {
		
		HashSet<Object> h = new HashSet<>();
		
		h.add("A");
		h.add("D");
		h.add("B");
		h.add("C");
		h.add(null);
		h.add(10);
		
		System.out.println(h.add("A")); //false
		System.out.println(h); //[null, A, B, C, D, 10] - insertion order is not preserved
	}

}
