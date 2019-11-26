package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract;

public class HDFCBank implements Bank {
	
	 private final String BNAME;
	 
     public HDFCBank(){  
            
    	 BNAME="HDFC BANK Ltd.";  
    }
     
    @Override
    public String getBankName() {  
              
    	return BNAME;  
    }  

}
