package com.bmc.practice.javaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

	public static void main(String[] args) {

		String fileName = "c:\\temp\\test\\abcd.txt";
		
		try  {
			FileReader fr =new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while(line != null) {
				
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
			
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
}
