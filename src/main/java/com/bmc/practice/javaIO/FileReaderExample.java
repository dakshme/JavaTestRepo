package com.bmc.practice.javaIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

	public static void main(String[] args) {
		String fileName = "c:\\temp\\test\\abc.txt";
		
		File f = new File(fileName);
		
		//reading character by character from a given file.
		try (FileReader fr = new FileReader(f);) {
			
			int ch = fr.read();
			while ( ch != -1 ) {	// -1 means EOF
				System.out.print((char)ch);
				ch = fr.read();
			}
			
		} catch (IOException e1) {	e1.printStackTrace();	}
		
		//reading full in one character array from a file.
		try (FileReader fr = new FileReader(f);) {
			
			char[] ch = new char[(int)f.length()];
			fr.read(ch);
			System.out.println("\n\n");
			for (char c:ch)
				System.out.print(c);
			
		} catch (IOException e) { 	e.printStackTrace(); 	}

		f=null;
	}
}
