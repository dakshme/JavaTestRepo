package com.bmc.practice.design.pattern.behavioral.command;

//Finally we'll set up a client to use the invoker

//Client
public class Client{

	public static void main(String[] args)    {
	
		RemoteControl control = new RemoteControl();
		
		//for light on/off operation
		Light light = new Light();
		Command lightsOn = new LightOnCommand(light);
		Command lightsOff = new LightOffCommand(light);
		
		//switch on
		control.setCommand(lightsOn);
		control.pressButton();
		
		//switch off
		control.setCommand(lightsOff);
		control.pressButton();
	}
}
