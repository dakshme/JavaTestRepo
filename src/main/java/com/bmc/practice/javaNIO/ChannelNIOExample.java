package com.bmc.practice.javaNIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ChannelNIOExample {

	public static void main(String[] args) {

		String file = "c:\\temp\\test\\ChannelNIO.txt";
		
		//read data from file using file channel
		try {
			FileInputStream fis = new FileInputStream(file);
			FileChannel fc = fis.getChannel();
			
			ByteBuffer bb =  ByteBuffer.allocate(100);			
			
			while(fc.read(bb) > 0) {
				bb.rewind();
				String str = Charset.forName("UTF-8").decode(bb).toString();
				System.out.println(str); //Channel NIO Demo program
				bb.flip();
			}			
			
		} catch (IOException e) { 	}
	
		//write data to file using file channel
		try {
			FileOutputStream fos = new FileOutputStream(file,true);
			FileChannel fc = fos.getChannel();
			
			ByteBuffer bb =  ByteBuffer.allocate(1000);			
	
			String deal = " upto 10% off on fashion";
			bb.put(deal.getBytes());
			bb.flip();
			fc.write(bb);
			
			deal = ",upto 30% off on bags";
			bb.flip();
			bb.put(deal.getBytes());
			bb.flip();
			fc.write(bb);
		} catch (IOException e) {  }
	}
}
