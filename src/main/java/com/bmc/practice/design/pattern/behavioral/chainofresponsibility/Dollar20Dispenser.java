package com.bmc.practice.design.pattern.behavioral.chainofresponsibility;

/*
 * We need to create different processor classes that will implement the DispenseChain
 * interface and provide implementation of dispense methods.  Since we are developing 
 * our system to work with three types of currency bills – 50$, 20$ and 10$,
 */

public class Dollar20Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" 20$ note");
			if(remainder !=0) 
				this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}
}
