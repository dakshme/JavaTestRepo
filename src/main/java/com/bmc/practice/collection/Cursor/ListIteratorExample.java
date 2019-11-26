package com.bmc.practice.collection.Cursor;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorExample {

	public static void main(String[] args) {
		
		LinkedList<Object> l = new LinkedList<>();
		l.add("Mahesh");
		l.add(null);
		l.add("Marsh");
		l.add("kal");
		l.add("chal");
		System.out.println(l); //[Mahesh, null, Marsh, kal, chal]
		
		ListIterator<Object> lI = l.listIterator();
		
		while (lI.hasNext()) {
			String str = (String)lI.next();
			
			if (str!=null && str.equals("Mahesh")) {
				lI.remove();
				System.out.println(l); //[null, Marsh, kal, chal]
			}
			else if (str!=null && str.equals("Marsh")) {
				lI.add("Adding");
				System.out.println(l); //[null, Marsh, Adding, kal, chal]
			}
			else if (str!=null && str.equals("kal")) {
				lI.set("Aaj");
				System.out.println(l); //[null, Marsh, Adding, Aaj, chal]
			}
		}
		
		System.out.println(l); //[null, Marsh, Adding, Aaj, chal]
	}

}
