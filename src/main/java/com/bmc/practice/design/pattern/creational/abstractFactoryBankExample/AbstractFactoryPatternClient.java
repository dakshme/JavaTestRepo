package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample;


import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract.Bank;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract.Loan;


//Use the FactoryCreator to get AbstractFactory in order to get factories of concrete classes
//by passing an information such as type.
public class AbstractFactoryPatternClient {

	public static void main(String args[]) {
		
		//example education loan from SBI bank
		String bankName = "SBI";
		String loanType = "Education";
		double rate = 8;
		double loanAmount = 100000;
		int years = 5;
		
		AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");  
		Bank b  = bankFactory.getBank(bankName); 
		
		System.out.println(loanType+" Loan from bank "+b.getBankName());
		
		AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");  
        Loan l=loanFactory.getLoan(loanType);  
        l.getInterestRate(rate);  
        l.calculateLoanPayment(loanAmount,years);
        
		//example 2
        bankName = "ICICI";
		loanType = "Home";
		rate = 9;
		loanAmount = 2500000;
		years = 20;
		
		bankFactory = FactoryCreator.getFactory("Bank");  
		b  = bankFactory.getBank(bankName); 
		
		System.out.println(loanType+" Loan from bank "+b.getBankName());
		
		loanFactory = FactoryCreator.getFactory("Loan");  
        l=loanFactory.getLoan(loanType);  
        l.getInterestRate(rate);  
        l.calculateLoanPayment(loanAmount,years);
	}
}
