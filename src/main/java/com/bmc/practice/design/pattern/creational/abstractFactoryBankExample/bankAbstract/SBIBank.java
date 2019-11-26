package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract;

public class SBIBank implements Bank{  
	
    private final String BNAME;  
    
    public SBIBank(){  
        
    	BNAME="SBI BANK Ltd";  
    }  
    
    @Override
    public String getBankName(){  

    	return BNAME;  
     }  
}
