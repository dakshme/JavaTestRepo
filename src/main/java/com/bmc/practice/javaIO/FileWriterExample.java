package com.bmc.practice.javaIO;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) throws IOException {

		String fileName = "c:\\temp\\test\\abc.txt";
		FileWriter fw = new FileWriter(fileName);
		//FileWriter fw = new FileWriter(fileName, true); //append mode
		
		fw.write(97); //a
		fw.write('b');
		fw.write("\ncdefg");
		fw.write('\n');
		
		char[] ch1= {'h', 'i', 'j', 'k','l'};
		fw.write(ch1);
		
		fw.write('\n');
		
		fw.flush();
		fw.close();
		
		System.out.println("All contents flushed in to the file");
		
	}
}
