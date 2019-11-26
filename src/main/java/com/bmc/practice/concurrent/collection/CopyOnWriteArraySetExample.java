package com.bmc.practice.concurrent.collection;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {

	public static void main(String[] args) {

		CopyOnWriteArraySet<String> cs = new CopyOnWriteArraySet<>();

			cs.add("A");
			cs.add("Z");
			cs.add("F");
			cs.add("E");
			cs.add("U");
			cs.add("A"); //duplicates not allowed
			cs.add(null); //single null entry allowed
			System.out.println(cs);
	}

}

//O/P = [A, Z, F, E, U, null]
