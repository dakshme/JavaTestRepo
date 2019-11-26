package com.bmc.practice.enumExample;

enum WeekDays{
	SUN,MON,TUE,WED,THR,FRI,SAT;
	
	//enum constructor
	
	WeekDays() {
		System.out.println("enum constructor");
	}
}

public class EnumConstructor {

	public static void main(String[] args) {
		
		WeekDays w = WeekDays.TUE;
		
		System.out.println("Main method");
	}
}
