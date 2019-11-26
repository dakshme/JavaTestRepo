package com.bmc.practice.collection.list;

import java.util.Vector;

public class VectorExample {
	
	public static void main(String[] args) {
		
		Vector<Object> v = new Vector<>();
		System.out.println(v.capacity()); //10
		
		for (int i = 0; i<10; i++)
			v.addElement(new Integer(i));
		
		v.add("A"); //adding 11th element
		System.out.println(v.capacity()); //20
		
		System.out.println(v); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A]
		
		/* Vector with incremental capacity, will not simply double as above case */
		Vector<Object> v1 = new Vector<>(10, 5);
		for (int i = 0; i<10; i++)
			v1.addElement(i);
		
		v1.add("ZZ"); //adding 11th element
		System.out.println(v1.capacity()); //15
		
		System.out.println(v1); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, ZZ]

	}

}
