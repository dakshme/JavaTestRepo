package com.bmc.practice.design.pattern.behavioral.command;


//Light is our receiver class, so let's set that up now:

//this receiver will directly talk to client

public class Light {

	private boolean on;
	  
	public void switchOn(){
	
		on = true;
		System.out.println("Light is on");
	}
	  
	public void switchOff(){
	
		on = false;
		System.out.println("Light is off");
	}
}
