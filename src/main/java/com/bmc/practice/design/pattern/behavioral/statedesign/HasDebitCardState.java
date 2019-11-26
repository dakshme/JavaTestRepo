package com.bmc.practice.design.pattern.behavioral.statedesign;

public class HasDebitCardState implements ATMMachineState {

	@Override
	public void executeATMState() {
		
		System.out.println("ATM Card Inserted: Enter Pin and amount");
		
	}

}
