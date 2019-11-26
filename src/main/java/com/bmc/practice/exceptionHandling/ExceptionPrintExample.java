package com.bmc.practice.exceptionHandling;

public class ExceptionPrintExample {

	public static void main(String[] args) {

        try { 
            int a = 20/0; 
        } catch (ArithmeticException e)  { 
	
     	    // printStackTrace method. prints line numbers + call stack.
            e.printStackTrace();

            // toString method 
            System.out.println(e.toString());             
            // OR 
            System.out.println(e); 

            // getMessage method. Prints only the message of exception and not the name of exception.
            System.out.println(e.getMessage()); 
        } 
	}
}
