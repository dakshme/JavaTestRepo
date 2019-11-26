package com.bmc.practice.collection.set;

/*
 * Arranging String objects in descending order (opposite of default natural sorting).
 *O/P= [ShobhaRani, Roja, Ramulamma, RajaKumari, GangaBhavani]
 */

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExampleString implements Comparator<String> {

	public static void main(String[] args) {
		
		TreeSet<String> t = new TreeSet<>(new ComparatorExampleString());
		
		t.add("Roja");
		t.add("ShobhaRani");
		t.add("RajaKumari");
		t.add("GangaBhavani");
		t.add("Ramulamma");
		
		System.out.println(t);
	}

	//Implement compare method of Comparator interface
	@Override
	public int compare(String o1, String o2) {
		
		return -o1.compareTo(o2); // for descending order (reverse of default natural sorting order)
		
		//Descending order can also be achieved using below technique i.e. reversing comparing objects
		//return o2.compareTo(o1); // for descending order (reverse of default natural sorting order)
	}

}
