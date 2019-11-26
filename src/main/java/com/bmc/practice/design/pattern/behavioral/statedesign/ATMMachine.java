package com.bmc.practice.design.pattern.behavioral.statedesign;

public class ATMMachine implements ATMMachineState {

	private ATMMachineState atmState;
	
	public ATMMachine() {
		
		//set the first state as default
		atmState = new NoDebitCardState();
	}
	
	//state getter
	
	public ATMMachineState getAtmMachineState ( ) {
		
		return this.atmState;
	}
	
	//state setter
	public void setAtmMachineState ( ATMMachineState atmState) {
		
		this.atmState = atmState;
	}
	
	@Override
	public void executeATMState() {
		
		// start this atm state machine with current default state
		
		atmState.executeATMState();
		
		//based on the previous selected state swtich the next state 
		if (atmState instanceof NoDebitCardState) {
			
			HasDebitCardState atmCardInsertedstate = new HasDebitCardState();
			setAtmMachineState(atmCardInsertedstate);
			System.out.println("State of atm machine has been moved to atm card inserted "+atmState.getClass().getName());
			
		} else if (atmState instanceof HasDebitCardState) {
			
			WithdrawMoneyState withdrawMoney = new WithdrawMoneyState();
			setAtmMachineState(withdrawMoney);
			System.out.println("State of atm machine moved to withdraw money "+atmState.getClass().getName());
			
		} else if (atmState instanceof WithdrawMoneyState) {
			
			System.out.println("No state after this. State of atm machine moved to dispensing money "+atmState.getClass().getName());
			
		}else {
			System.out.println("Invalid state found!!");
		}

	}

}
