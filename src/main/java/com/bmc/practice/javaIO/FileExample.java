package com.bmc.practice.javaIO;

import java.io.File;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args) {

		File f = new File("c:\\temp\\abc.txt");
		
		System.out.println(f.exists()); //false 
		
		try {
			f.createNewFile();
		} catch (IOException e) {	e.printStackTrace(); 	}
		
		System.out.println(f.exists());  //true
		
		f.delete();
		
		System.out.println(f.exists());  //false
		
		//list files present in specified sub directory
		
		File f1 = new File ("c:\\temp\\");
		
		String[] s = f1.list();
		
		for (String s1: s) 
			System.out.println(s1); //		Encoding Time.csv
									//		Intel-SA-00075-result.txt
									//		mydebug.txt
									//		mydebug.txt.~1~

		
		//to just display files and not directory
		for (String s1: s)  {
			File f2 = new File (f1, s1);
			if (f2.isFile())
				System.out.println(s1);
		}
		
		//to display only directory
		for (String s1: s)  {
			File f2 = new File (f1, s1);
			if (f2.isDirectory())
				System.out.println(s1);
		}
	}
}
