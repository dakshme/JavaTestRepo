package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract;

public class HomeLoan extends Loan{
	
	//implement abstract method
    public void getInterestRate(double r){  
    	
    	//rate of parent loan class
        rate=r;  
   }  
    
}//End of the HomeLoan class.  