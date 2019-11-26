package com.bmc.practice.design.pattern.behavioral.chainofresponsibility;

import java.util.Scanner;

public class ATMDispenseChainOfResponsibility {

	private DispenseChain c1;
	
	public ATMDispenseChainOfResponsibility() {
		
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		DispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) {

		ATMDispenseChainOfResponsibility atmDispenser = new ATMDispenseChainOfResponsibility();
		
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				break;
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
			//input.close();
		}
	}
}
