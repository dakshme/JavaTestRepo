package com.bmc.practice.design.pattern.creational.abstractFactoryBankExample;

import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.bankAbstract.Bank;
import com.bmc.practice.design.pattern.creational.abstractFactoryBankExample.loanAbstract.Loan;

//Create an abstract class (i.e AbstractFactory) to get the factories for Bank and Loan Objects.
public abstract class AbstractFactory {

	public abstract Bank getBank(String bank);
	public abstract Loan getLoan(String loan);  
}
