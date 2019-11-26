package com.bmc.practice.javaIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) {
		
		String fileName = "c:\\temp\\test\\abc.txt";

		try (FileWriter fw = new FileWriter(fileName);  //try with resource
			PrintWriter pw = new PrintWriter(fw);) {

			pw.write(97);  // char a
			pw.println(97);   // print number 97, will be appended with prev line as \n added at the end
			pw.println('b');
			pw.println("cdefg");
			pw.println(true);
						
			pw.flush();
			pw.close();
			
		} catch (IOException e) { 	e.printStackTrace(); 	}
	}
}
