package com.bmc.practice.collection.set;

/*
 * This will result in to run time exception
 * Exception in thread "main" java.lang.ClassCastException: java.lang.StringBuffer cannot be cast to java.lang.Comparable
	at java.util.TreeMap.compare(Unknown Source)
 *
 * As the StringBuffer class is not comparable. 	
 */

import java.util.TreeSet;

public class TreeSetExample2 {

	public static void main(String[] args) {
		
		TreeSet<StringBuffer> t = new TreeSet<>();
		
		t.add(new StringBuffer("N"));
		t.add(new StringBuffer("B"));
		t.add(new StringBuffer("L"));
		t.add(new StringBuffer("Z"));
		
		System.out.println(t);
	}

}
