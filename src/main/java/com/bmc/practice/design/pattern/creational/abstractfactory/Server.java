package com.bmc.practice.design.pattern.creational.abstractfactory;

public class Server implements Computer {

	private String RAM;
	private String HDD;
	private String CPU;
	

	public Server(String rAM, String hDD, String cPU) {

		RAM = rAM;
		HDD = hDD;
		CPU = cPU;
	}

	@Override
	public String getRAM() {

		return this.RAM;
	}

	@Override
	public String getRDD() {

		return this.HDD;
	}

	@Override
	public String getCPU() {

		return this.CPU;
	}

}
