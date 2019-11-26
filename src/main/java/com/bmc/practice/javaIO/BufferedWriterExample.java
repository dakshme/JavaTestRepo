package com.bmc.practice.javaIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {

	public static void main(String[] args) {
		
		String fileName = "c:\\temp\\test\\abcd.txt";

		try (FileWriter fw = new FileWriter(fileName);  //try with resource
			BufferedWriter bw = new BufferedWriter(fw);) {

			bw.write(97);   //a
			bw.write('b');
			bw.newLine();
			bw.write("cdefg");
			bw.newLine();
			
			char[] ch1= {'h', 'i', 'j', 'k','l'};
			bw.write(ch1);
			
			bw.newLine(); 
			
			bw.write("mnop");
			
			bw.flush();
			bw.close();
			
		} catch (IOException e) { 	e.printStackTrace(); 	}
	}

}
