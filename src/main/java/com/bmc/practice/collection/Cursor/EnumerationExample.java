package com.bmc.practice.collection.Cursor;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationExample {

	public static void main(String[] args) {
		
		Vector<Object> v = new Vector<>();
		
		for (int i = 0; i<=10; i++)
			v.addElement(new Integer(i));
		
		System.out.println(v); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
		Enumeration<Object> e = v.elements();
		
		while (e.hasMoreElements()) {
			Integer i = (Integer) e.nextElement();
			
			//print only even integer objects
			if (i % 2 == 0) {
				System.out.print(i+" "); // 0 2 4 6 8 10 
			}
		}

	}

}
