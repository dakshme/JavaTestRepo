package com.bmc.practice.exceptionHandling;

/*
 * Example showing Error try-with-resource can not be reassigned.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceExample {

	public static void main (String[] args) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt")) ) {
			
			br = new BufferedReader(new FileReader("output.txt")); //Error try-with-resource can not be reassigned.
		} 
	}
}
