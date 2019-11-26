package com.bmc.practice.collection.set;


/*
 * Comparing and arranging heterogeneous objects in TreeSet using Comparator.
 * O/P = [A, AA, XX, ABC, ABCD]
 */
import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExampleHeteroObjects implements Comparator<Object> {

	public static void main(String[] args) {
		
		TreeSet<Object> t = new TreeSet<>(new ComparatorExampleHeteroObjects());
		
		t.add("A");
		t.add(new StringBuffer("ABC"));
		t.add(new StringBuffer("AA"));
		t.add("XX");
		t.add("ABCD");
		t.add("A");
		
		System.out.println(t);
	}

	@Override
	public int compare(Object o1, Object o2) {

		String obj1 = o1.toString();
		String obj2 = o2.toString();
		
		int l1 = obj1.length();
		int l2 = obj2.length();
		
		if (l1 > l2) //length wise sorting
			return 1;
		else if (l1 < l2) //length wise sorting
			return -1;
		else
			return obj1.compareTo(obj2);  // if length same then DNSO 
	}
}
