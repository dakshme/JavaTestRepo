package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample;

import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract.Bank;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract.HDFCBank;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract.ICICIBank;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract.SBIBank;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract.Loan;

public class BankFactory extends AbstractFactory{  
	
	@Override
	public Bank getBank(String bank){
		
		if(bank == null){  
			return null;  
		}
		
		if(bank.equalsIgnoreCase("HDFC")){  
			
		    return new HDFCBank();
		    
		} else if(bank.equalsIgnoreCase("ICICI")){ 
			
			return new ICICIBank();  
			
	    } else if(bank.equalsIgnoreCase("SBI")){
	    	
	    	return new SBIBank();  
		}
		
		return null;  
	}  
		
	public Loan getLoan(String loan) {  
	      return null;  
	}  
}//End of the BankFactory class.  