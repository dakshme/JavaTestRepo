package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample;

import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract.Bank;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract.BussinessLoan;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract.EducationLoan;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract.HomeLoan;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract.Loan;

public class LoanFactory extends AbstractFactory{  
	
    public Bank getBank(String bank){ 
    	
        return null;  
	}  

	public Loan getLoan(String loan){  
		
		if(loan == null){  
			return null;  
		}
	
		if(loan.equalsIgnoreCase("Home")){  
			
			return new HomeLoan();  
		} else if(loan.equalsIgnoreCase("Business")){
			
			return new BussinessLoan();  
		} else if(loan.equalsIgnoreCase("Education")){
			
			return new EducationLoan();  
		}
		
		return null;  
	}  
}  
