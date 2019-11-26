package com.bmc.practice.collection.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapExample {

	public static void main(String[] args) {

		LinkedHashMap<String, Integer> m = new LinkedHashMap<>();
		
		m.put("Chir", 500);
		m.put("balai", 800);
		m.put("Venky", 200);
		m.put("Naga", 140);

		System.out.println(m);  //{Chir=500, balai=800, Venky=200, Naga=140}
		
		//replace existing key and return the old value associated with key 
		System.out.println(m.put("Chir", 1000));   //500
		
		//get the set of all keys from Map
		Set<String> s = m.keySet();
		System.out.println(s);  // [Chir, balai, Venky, Naga]
		
		//get the Collection of all values present in Map
		Collection<Integer> c = m.values();
		System.out.println(c);  // [1000, 800, 200, 140]
		
		//Get all Entry objects from Map
		Set s1 = m.entrySet();
		System.out.println(s1); //  [Chir=1000, balai=800, Venky=200, Naga=140]

		//Iterate all the Entry objects got from Map, Iterator can be applied on Collection only and NOT on Map
		Iterator<Map.Entry<String, Integer>> itr = s1.iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next();
			System.out.println(e.getKey()+"...."+e.getValue());

			//modify One of the entry here to be reflected in map
			if (e.getKey().equals("Chir"))
				e.setValue(80000);			
		}
		
		//at last print Map contents
		System.out.println(m);  //{Chir=80000, balai=800, Venky=200, Naga=140}

	}

}
