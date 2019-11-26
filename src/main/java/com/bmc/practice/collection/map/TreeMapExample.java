package com.bmc.practice.collection.map;

import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {

		TreeMap<Integer, Object> t = new TreeMap<>();
		t.put(101,"AA");
		t.put(100,"VV");
		t.put(120,"DD");
		t.put(50,"ZZ");
		t.put(90,666);
		
		//t.put("TT","GG"); // ClassCastException
		//t.put(null,"FF"); //NullPointerException
		System.out.println(t);  // {50=ZZ, 90=666, 100=VV, 101=AA, 120=DD}
	}
}
