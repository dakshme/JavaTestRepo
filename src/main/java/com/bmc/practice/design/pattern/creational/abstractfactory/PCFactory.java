package com.bmc.practice.design.pattern.creational.abstractfactory;

public class PCFactory implements ComputerAbstractFactory {

	@Override
	public Computer createComputer() {

		return new PC(this.RAM,this.HDD, this.CPU);
	}
	
	private String RAM;
	private String HDD;
	private String CPU;
	

	public PCFactory(String rAM, String hDD, String cPU) {

		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}


}
