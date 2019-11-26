package com.bmc.practice.collection.Cursor;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

	public static void main(String[] args) {
		
		ArrayList<Object> l = new ArrayList<>();
		
		for (int i = 0; i<=10; i++)
			l.add(i);
		
		System.out.println(l); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
		Iterator<Object> i = l.iterator();
		
		while(i.hasNext()) {
			Integer nmbr = (Integer )i.next();
			if (nmbr % 2 == 0) 
				System.out.print(nmbr+" "); //0 2 4 6 8 10 
			else 
				i.remove(); //remove odd number from ArrayList
		}
		
		System.out.println("\n"+l); //[0, 2, 4, 6, 8, 10] - only even number
	}

}
