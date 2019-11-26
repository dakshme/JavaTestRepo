package com.bmc.practice.design.pattern.creational.abstractfactory;

public class ServerFactory implements ComputerAbstractFactory {

	@Override
	public Computer createComputer() {

		return new Server(this.RAM,this.HDD, this.CPU);
	}

	private String RAM;
	private String HDD;
	private String CPU;
	

	public ServerFactory(String rAM, String hDD, String cPU) {

		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}
	
}
