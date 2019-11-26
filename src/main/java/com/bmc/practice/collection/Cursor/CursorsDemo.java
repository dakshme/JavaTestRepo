package com.bmc.practice.collection.Cursor;

/*
 * Internal Implementation of cursors
 * Implemented class for cursors
 */

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;


public class CursorsDemo {

	public static void main(String[] args) {
		
		Vector<Object > v = new Vector<>();
		
		Enumeration<Object> e = v.elements();
		System.out.println(e.getClass().getName()); // java.util.Vector$1
		
		Iterator<Object> i = v.iterator();
		System.out.println(i.getClass().getName()); //java.util.Vector$Itr
		
		ListIterator<Object> lI = v.listIterator();
		System.out.println(lI.getClass().getName()); //		java.util.Vector$ListItr
	}
}
