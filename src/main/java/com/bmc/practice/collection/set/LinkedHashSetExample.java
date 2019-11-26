package com.bmc.practice.collection.set;

/*
 * LinkedHashSet is similar to HashSet other than the insertion order is preserved.
 */

import java.util.LinkedHashSet;

public class LinkedHashSetExample {

public static void main(String[] args) {
		
		LinkedHashSet<Object> h = new LinkedHashSet<>();
		
		h.add("A");
		h.add("D");
		h.add("B");
		h.add("C");
		h.add(null);
		h.add(10);
		
		System.out.println(h.add("A")); //false
		System.out.println(h); //[A, D, B, C, null, 10] - insertion order is preserved in LinkedHashSet
	}
	
}
