package com.bmc.practice.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {

		HashMap<String, Integer> m = new HashMap<>();
		
		m.put("Chir", 500);
		m.put("balai", 800);
		m.put("Venky", 200);
		m.put("Naga", 140);

		System.out.println(m);  //{Venky=200, balai=800, Naga=140, Chir=500}
		
		//replace existing key and return the old value associated with key 
		System.out.println(m.put("Chir", 1000));   //500
		
		//get the set of all keys from Map
		Set<String> s = m.keySet();
		System.out.println(s);  // [Venky, balai, Naga, Chir]
		
		//get the Collection of all values present in Map
		Collection<Integer> c = m.values();
		System.out.println(c);  // [200, 800, 140, 1000]
		
		//Get all Entry objects from Map
		Set s1 = m.entrySet();
		System.out.println(s1); //  [Venky=200, balai=800, Naga=140, Chir=1000]

		//Iterate all the Entry objects got from Map, Iterator can be applied on Collection only and NOT on Map
		Iterator<Map.Entry<String, Integer>> itr = s1.iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next();
			System.out.println(e.getKey()+"...."+e.getValue());
			/*
			 * O/P = 
			 * Venky....200
			 * balai....800
			 * Naga....140
			 * Chir....1000
			 */
			//modify One of the entry here to be reflected in map
			if (e.getKey().equals("Chir"))
				e.setValue(80000);			
		}
		
		//at last print Map contents
		System.out.println(m);  //{Venky=200, balai=800, Naga=140, Chir=80000}
	}
}
