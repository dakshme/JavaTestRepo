package com.bmc.practice.strings;

public class ReverseStringWithOutApi {

	public void reverseString(String str) {
		
		for (int i=str.length()-1; i>=0; i--)
			System.out.print(str.charAt(i));
	}
	
	public void reverse1(String str, char delim) {
		
		char strArray[] = str.toCharArray();
		
		int len=strArray.length-1;
		int count = 0;
		while (len!=0) {
			
			count++;
			if (strArray[len] == delim || len==1) {
				int skipSpace=0;
				
				//remove white space
				if (len!=1) {
					skipSpace = len+1;
					count--;
				}
				else { 
					skipSpace = len-1;
					count++;
				}
				
				char temp[] = new char[count];
				
				for (int j=0; j<count; j++)
					temp[j] = strArray[skipSpace+j];
				
				for (char c : temp)
					System.out.print(c);
				
				//print remove space now
				if (len!=1)
					System.out.print(" ");
				
				count=0;
			}				
			len--;
		}
			
		
		System.out.println("");
		for (int i=strArray.length-1; i>=0; i--)
			System.out.print(strArray[i]);
		
	}
	
	
	public static void main (String [] args) {
		
		ReverseStringWithOutApi revNoApi = new ReverseStringWithOutApi();
		revNoApi.reverse1("Reverse me Animesh with a smart solution !!!", ' ');
	}
}
