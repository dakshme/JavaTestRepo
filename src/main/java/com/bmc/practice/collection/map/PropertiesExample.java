package com.bmc.practice.collection.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		FileInputStream is = null;
		String fileName = "C:\\WorkingDirectory\\JavaTestProgramWorkSpace\\com.bmc.practice.test\\src\\main\\java\\com\\bmc\\practice\\collection\\map\\abc.properties";
		try {
			is = new FileInputStream(fileName);
		} catch (FileNotFoundException e) { 	e.printStackTrace(); 		}
		
		try {
			p.load(is);
		} catch (IOException e) { 	e.printStackTrace(); 	}
		
		System.out.println(p); // {db=Oracle, user=scott, password=tiger}
		
		String s = p.getProperty("db");
		System.out.println(s);  // Oracle
		
		p.setProperty("Org", "TCS");
		FileOutputStream os = new FileOutputStream(fileName);
		p.store(os, "Restoring all properties back to file");
	}

}
