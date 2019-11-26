package com.bmc.practice.collection.map;

import java.util.Hashtable;

public class HashtableExample {

	public static void main(String[] args) {
		
		Hashtable<Test, Object> h = new Hashtable<>();
		
		h.put(new Test(5), "A");
		h.put(new Test(2), "B");
		h.put(new Test(6), "C");
		h.put(new Test(15), "D");
		h.put(new Test(23), "E");
		h.put(new Test(16), "F");
		//h.put(null, "A"); // NullPointerException
		//h.put("Arbit", null); // NullPointerException
		System.out.println(h);  // O/P: {6 =C, 16 =F, 5 =A, 15 =D, 2 =B, 23 =E}
	}
}

class Test {
	
	int i;
	
	Test(int i ) {
		this.i=i;		
	}
	
	public int hashCode() {
		return this.i;
	}
	
	public String toString() {
		return i+" ";
	}
}
