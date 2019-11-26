package com.bmc.practice.collection.set;

/*
 * Example for custom sorting using Comparator interface. This example shows
 *  descending sorting which is not default narutal sorting order.
 */

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExampleInteger implements Comparator<Integer> {

	public static void main(String[] args) {
		TreeSet<Integer> t = new TreeSet<>(new ComparatorExampleInteger());
		
		t.add(12);
		t.add(3);
		t.add(8);
		t.add(30);
		t.add(0);
		t.add(100);
		
		System.out.println(t);

	}

	@Override
	public int compare(Integer o1, Integer o2) {
		/* Return in such a way to arrange in descending order */
		
		if (o1 < o2)
			return 1;
		else if (o1 > o2)
			return -1;

		//if equal
		return 0;
	}

}
