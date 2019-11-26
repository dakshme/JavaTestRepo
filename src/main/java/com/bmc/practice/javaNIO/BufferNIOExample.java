package com.bmc.practice.javaNIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class BufferNIOExample {

	public static void main(String[] args) {
		
		ByteBuffer bb =  ByteBuffer.allocate(110);
			
		CharBuffer cbuff = CharBuffer.allocate(50);
		cbuff.put("Best deals"); //fill buffers, use put methods of the buffer object
		
		char offer[] = "upto 20% off on travel".toCharArray();
		CharBuffer cb = CharBuffer.wrap(offer);	//create Buffer object by calling wrap() method and passing appropriate array 
		char c = cb.get(2);	//absolute get method
		System.out.println(c);  //s
		char d = cb.get();	//Relative get method, return value relative to the current position
		System.out.println(d);  //u
		
		char part[] = new char[5];
		cb.get(part); //access bulk values, get() methods passing array to it
		for (char ch: part)
			System.out.print(ch); //pto 2
		
		//IntBuffer
		IntBuffer ib = IntBuffer.allocate(40);
		ib.put(10);
		int vals[] = {2, 55, 34, 65};
		ib.put(vals);
		int val = ib.get(3);
		System.out.println("\n"+val); //34
		
		//get() return first element, you need to set the position to 0.
		cbuff.put("deals");	 //appends to previous string "Best deals"
		cbuff.position(0);
		System.out.println(cbuff.get()); //B
		System.out.println(cbuff.get()); //e
		while(cbuff.hasRemaining()) {
			System.out.print(cbuff.get()); //st dealsdeals
		}
		System.out.println("\n");
		
		//slice()
		char deals[] = "best deals for you".toCharArray();
		CharBuffer cb1 = CharBuffer.wrap(deals);
		cb1.position(5);
		
		CharBuffer cbs = cb1.slice();	//slice() from current position i.e. 5
		System.out.println(cbs.toString()); //deals for you
		System.out.println(cb1.toString()); //deals for you
		
		cbs.put(3, 'n');
		System.out.println(cbs.toString()); //deans for you
		System.out.println(cb1.toString()); //deans for you
		
	}

}
