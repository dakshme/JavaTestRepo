package com.bmc.practice.design.pattern.creational.abstractfactory;

//factory of these factories that will be used by client program

public class ComputerFactory {
	
	public static Computer createComputer( ComputerAbstractFactory caf ) // ComputerAbstractFactory will either be serverFactory or PCFactory, client need to pass while calling this
	{

		return caf.createComputer();

	}

}
