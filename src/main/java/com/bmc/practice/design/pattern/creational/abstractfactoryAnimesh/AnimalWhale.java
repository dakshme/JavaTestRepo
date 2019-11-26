/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class AnimalWhale implements IAnimalKingdom {

	@Override
	public String getAnimalInfo() {
		return "Animal name is Blue Whale";
	}
	
	@Override
	public String getAnimalHabitat() {
		return "Habitat of Blue Whate is Ocean";
	}
	
	@Override
	public String toString() {
		return "Animal name is Blue Whale";
	}
}
