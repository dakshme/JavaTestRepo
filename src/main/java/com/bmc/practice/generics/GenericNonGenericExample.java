package com.bmc.practice.generics;

import java.util.ArrayList;

public class GenericNonGenericExample {

	public static void main(String[] args) {

		/* This is generic area */
		ArrayList<String> al = new ArrayList<>();
		
		al.add("A");
		al.add("B");
		//al.add(10); compile time error
		nonGenericFunction (al);
		//al.add(10.5); compile time error
		System.out.println(al);

	}

	/* This is non generic area */
	private static void nonGenericFunction(ArrayList al) {
		
		al.add(10);
		al.add(45.3);
		al.add(true);
		al.add("LOL");		
	}
}
