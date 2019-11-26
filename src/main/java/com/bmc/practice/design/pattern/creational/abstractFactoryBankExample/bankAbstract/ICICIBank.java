package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract;

public class ICICIBank implements Bank {
	
	private final String BNAME;  
	
	public ICICIBank(){

		BNAME="ICICI BANK Ltd.";  
     }
	
	@Override
    public String getBankName() {  

		return BNAME;  
    }  

}
