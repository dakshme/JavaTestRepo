package com.bmc.practice.collection.set;

/*
 * Arranging StingBuffer object based on ascending order. We need to use Comparator interface
 * O/P = [A, C, G, W, Z]
 */

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExampleStringBuffer implements Comparator<StringBuffer> {

	public static void main(String[] args ) {
		
		TreeSet<StringBuffer> t = new TreeSet<>(new ComparatorExampleStringBuffer());  
		
		t.add(new StringBuffer("A"));
		t.add(new StringBuffer("Z"));
		t.add(new StringBuffer("G"));
		t.add(new StringBuffer("W"));
		t.add(new StringBuffer("C"));
		
		System.out.println(t);		
	}
	
	@Override
	public int compare(StringBuffer o1, StringBuffer o2) {

		String obj1 = o1.toString();
		String obj2 = o2.toString();
		
		//now as both the objects converted to String object we can call compareTo() method directly			
		return obj1.compareTo(obj2);
	}
}
