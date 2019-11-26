package com.bmc.practice.design.pattern.behavioral.statedesign;

public class NoDebitCardState implements ATMMachineState {

	@Override
	public void executeATMState() {
		
		System.out.println("No Debit card state: Please Insert ATM Card");
		
	}


}
