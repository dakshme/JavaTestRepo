package com.bmc.practice.javaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Merging 2 files in 3rd file with alternate lines.
 */

public class MergeFilesExample1 {

	public static void main(String[] args) throws IOException {
		String file1 = "c:\\temp\\test\\file1.txt";
		String file2 = "c:\\temp\\test\\file2.txt";
		String file3 = "c:\\temp\\test\\file3.txt"; //merge file1 and file2 to file3

		PrintWriter pw = new PrintWriter(file3);
		
		//read file1 and file2 and start putting in to file3 alternate lines
		BufferedReader br = new BufferedReader(new FileReader(file1));
		String line = br.readLine();
		BufferedReader br1 = new BufferedReader(new FileReader(file2));
		String line1 = br1.readLine();
		
		while(line != null || line1 != null) {
			if(line!=null)
				pw.println(line); //write file 1 line
			
			if(line1!=null)
				pw.println(line1);  //write file 2 line

			line = br.readLine();  //read next line
			line1 = br1.readLine(); //read next line
		}
		br.close();
		br1.close();
		pw.close();
	}

}
