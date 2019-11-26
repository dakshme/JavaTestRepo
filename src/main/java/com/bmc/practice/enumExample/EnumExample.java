package com.bmc.practice.enumExample;

/*
 * Passing enum to switch case
 */

enum Months {
	JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC;
}

public class EnumExample {

	public static void main(String[] args) {
		Months m = Months.APR;
		
		System.out.println(m+" "+m.ordinal());
		System.out.println(Months.AUG+" "+Months.AUG.ordinal());
		
		switch( m ) {
		
		case JAN: 
			System.out.println("Month Jan");
			break;
		case FEB: 
			System.out.println("Month Feb");
			break;
		case MAR: 
			System.out.println("Month Mar");
			break;
		case APR: 
			System.out.println("Month Apr");
			break;
		case MAY: 
			System.out.println("Month May");
			break;
		default:
			System.out.println("Any other month.");
		
		}
	}
}
