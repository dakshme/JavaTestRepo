package com.bmc.practice.collection.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueComparatorExample {

	public static void main(String[] args) {
		
		PriorityQueue< Object> q = new PriorityQueue<>(15, new MyComparator());
		q.offer("A");
		q.add("D");
		q.add("Z");
		q.offer("F");
		
		System.out.println(q); // [Z, F, D, A]
	}
}

class MyComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		String s1 = o1.toString();
		String s2 = o2.toString();
		return s2.compareTo(s1); //descending order sorting
	}	
}
