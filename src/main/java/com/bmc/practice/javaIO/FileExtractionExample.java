package com.bmc.practice.javaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileExtractionExample {

	public static void main(String[] args) throws IOException {
		
		String inputFile = "c:\\temp\\test\\input.txt";
		String deleteFile = "c:\\temp\\test\\delete.txt";
		String outputFile = "c:\\temp\\test\\output.txt";
		boolean found = false;

		//open output file to wtire
		PrintWriter pw = new PrintWriter(outputFile);
		
		BufferedReader br = new BufferedReader(new FileReader(inputFile));  //read input file
		
		String inputLine = br.readLine();
		
		while (inputLine != null) {
			
			//check if this line present in delete file
			BufferedReader br1 = new BufferedReader(new FileReader(deleteFile)); //read delete file
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
			
			br1.close();
			found = false; //reset found flag back
			
			inputLine = br.readLine();		//read next record
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
