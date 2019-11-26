package com.bmc.practice.collection.set;

import java.util.TreeSet;

/*
 * Default natural sorting order with default constructor
 * 
 */
public class TreeSetExample1 {
	
	public static void main(String[] args) {
		
		TreeSet<Object> t = new TreeSet<>();
		t.add("A");
		t.add("a");
		t.add("Z");
		t.add("L");
		t.add("B");
		
		//t.add(null);  //NPE - as inserting null not allowed 1.7 version onward
		//t.add(new Integer(10));  //ClassCastException
		
		System.out.println(t); //[A, B, L, Z, a] - Natural sorting order of alphabets
	}

}
