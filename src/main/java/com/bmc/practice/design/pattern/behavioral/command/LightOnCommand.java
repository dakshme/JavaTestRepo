package com.bmc.practice.design.pattern.behavioral.command;

//Now let's create two concrete commands. One will turn on the lights, another turns off lights:

//Concrete Command
public class LightOnCommand implements Command{
	
	//reference to the light
	Light light;
	
	public LightOnCommand(Light light){
	
		this.light = light;
	}
	
	public void execute(){
	
		light.switchOn();
	}
}
