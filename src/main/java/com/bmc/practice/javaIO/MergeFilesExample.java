package com.bmc.practice.javaIO;

/*
 * Merging 2 files in 3rd file sequentially.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeFilesExample {

	public static void main(String[] args) throws IOException {
		String file1 = "c:\\temp\\test\\file1.txt";
		String file2 = "c:\\temp\\test\\file2.txt";
		String file3 = "c:\\temp\\test\\file3.txt"; //merge file1 and file2 to file3

		PrintWriter pw = new PrintWriter(file3);
		
		//read file 1 and start appending to file 3
		BufferedReader br = new BufferedReader(new FileReader(file1));
		String line = br.readLine();
		
		while(line != null) {
			pw.println(line);
			line = br.readLine();
		}
		br.close();
		
		//read file 2 and start appending to file 3
		br = new BufferedReader(new FileReader(file2));
		line = br.readLine();
		
		while(line != null) {
			pw.println(line);
			line = br.readLine();
		}
		br.close();
		pw.close();
	}
}
