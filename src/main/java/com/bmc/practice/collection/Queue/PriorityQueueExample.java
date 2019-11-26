package com.bmc.practice.collection.Queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		PriorityQueue<Object> mq = new PriorityQueue<>();
		
		System.out.println(mq.peek()); //null
		//System.out.println(mq.element()); //NoSuchElementException (NSEE)
		
		for (int i = 0; i<=10; i++) {
			//mq.add(i);  //same as offer()
			mq.offer(i);
		}
		
		System.out.println(mq);  // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println(mq.poll());  // 0 - remove and return
		System.out.println(mq); //[1, 3, 2, 7, 4, 5, 6, 10, 8, 9]
	}
}
