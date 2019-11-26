package com.bmc.practice.design.pattern.creational.abstractfactory;

public class ComputerClient {

	public static void main(String[] args) {
		
		Computer pc = ComputerFactory.createComputer(new PCFactory("4bg", "250gb", "2.4ghz"));
		
		Computer server = ComputerFactory.createComputer(new ServerFactory("16bg", "2TB", "500Mhz"));
		
		Computer laptop = ComputerFactory.createComputer(new LaptopFactory());

	}

}
