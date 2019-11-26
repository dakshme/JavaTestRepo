package com.bmc.practice.design.pattern.behavioral.statedesign;

public class WithdrawMoneyState implements ATMMachineState {

	@Override
	public void executeATMState() {
		
		System.out.println("Withdraw cash state: dispensing money now...");
		
	}

}
