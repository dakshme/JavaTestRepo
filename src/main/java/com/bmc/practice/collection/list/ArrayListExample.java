package com.bmc.practice.collection.list;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {

		ArrayList<Object> l = new ArrayList<>();
		
		l.add("A"); //insert string
		l.add(10); //insert Integer
		l.add("B");
		l.add(2);
		l.add(3);
		l.add(null); //insert null
		l.add("A");

		System.out.println(l); // [A, 10, B, 2, 3, null, A]

		l.remove(3);
		l.remove("A");
		System.out.println(l); // [10, B, 3, null, A]

		l.add(0, "Z");
		l.add("LL");
		System.out.println(l); // [Z, 10, B, 3, null, A, LL]
	}

}
