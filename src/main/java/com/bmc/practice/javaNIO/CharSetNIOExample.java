package com.bmc.practice.javaNIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class CharSetNIOExample {

	public static void main(String[] args) {

		String deal = "upto 55% off on fashion";
		CharBuffer cbuff = CharBuffer.wrap(deal);
		
		Charset cs = Charset.forName("UTF-8");
		ByteBuffer bb = cs.encode(cbuff);
		
		CharBuffer cb = cs.decode(bb);
		System.out.println(new String(cb.array())); //upto 55% off on fashion

	}

}
