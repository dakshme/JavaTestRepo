package com.bmc.practice.design.pattern.behavioral.command;

//Our invoker in this case is the remote control.
//Invoker
public class RemoteControl{

	private Command command;
	
	public void setCommand(Command command){
	
		this.command = command;
	}
	
	public void pressButton(){
	  
		command.execute();
	}
}