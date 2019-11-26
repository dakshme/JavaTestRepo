package com.bmc.practice.design.pattern.behavioral.statedesign;

public class Client {
	
	public static void main (String[] args) {
		
		//atm machine operation class
		ATMMachine useMachine = new ATMMachine();
		
		System.out.println("This machine current state is "+useMachine.getAtmMachineState().getClass().getName());
		
		//now start operations
		useMachine.executeATMState(); //insert card. Seamless movement from one state to another
		useMachine.executeATMState(); //has card card, enter pin and amount
		useMachine.executeATMState(); //dispensing cash
		
	}

}
