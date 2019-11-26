package com.bmc.practice.design.pattern.creational.abstractfactory;

public class LaptopFactory implements ComputerAbstractFactory {

	@Override
	public Computer createComputer() {

		return new Laptop();
	}
	

}
