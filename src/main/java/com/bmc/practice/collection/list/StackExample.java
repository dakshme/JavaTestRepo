package com.bmc.practice.collection.list;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Object> s = new Stack<>();
		
		s.add("A");
		s.push("B");
		s.push("C");
		s.add("D");		
		System.out.println(s); // [A, B, C, D]
		
		System.out.println(s.search("A")); //4
		System.out.println(s.search("Z")); //-1
		
		s.remove(0);
		System.out.println(s); //[B, C, D]
		String top = (String) s.pop();
		System.out.println("popped: "+top); //popped: D
		System.out.println(s); //[B, C]
		
		System.out.println(s.capacity()); //10 
	}

}
