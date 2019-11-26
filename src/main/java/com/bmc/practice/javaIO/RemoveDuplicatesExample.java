package com.bmc.practice.javaIO;

//Program to remove duplicates from a given file and put unique numbers to a separate file

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveDuplicatesExample {

	public static void main(String[] args) throws IOException {
		
		String inputFile = "c:\\temp\\test\\duplicates.txt";
		String outputFile = "c:\\temp\\test\\output.txt";
		boolean found = false;

		//open output file to write
		PrintWriter pw = new PrintWriter(outputFile);
		
		BufferedReader br = new BufferedReader(new FileReader(inputFile));  //read input file
		
		String inputLine = br.readLine();
		
		while (inputLine != null) {
			
			//check if this line already present in output file
			BufferedReader br1 = new BufferedReader(new FileReader(outputFile)); //read output file
			String targetLine= br1.readLine();
			while (targetLine != null) {
				
				if (targetLine.equals(inputLine)) {
					found = true;
					break;
				}
				targetLine= br1.readLine();
			}
			if(found == false)
				pw.println(inputLine); //if not found in delete file put in to output file
			
			pw.flush(); //flush content, otherwise on some OS it does it very late.
			br1.close();
			found = false; //reset found flag back
			
			inputLine = br.readLine();		//read next record
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
